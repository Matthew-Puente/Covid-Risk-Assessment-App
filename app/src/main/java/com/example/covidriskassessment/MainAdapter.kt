package com.example.covidriskassessment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerviewlayout.view.*

class MainAdapter:RecyclerView.Adapter<CustomViewHolder>(){
    val Questions = listOf<String>("Asthma?","Cardiovascular Disease?","Chronic Lung Disease?","Immune Suppression?","Metabolic Disease?","Neurologic Disease?","Auto-Immune Disease?","Liver Disease?","Obesity?","Pregnancy?","Obestiy","Pregnancy","Hypertension?")
    val Options = listOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.recyclerviewlayout,parent,false)
        return CustomViewHolder(cellForRow)
    }
    // # of items
    override fun getItemCount(): Int {
        return Questions.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val Question = Questions.get(position)
        holder?.view?.textView2?.text = Question

    }
}

class CustomViewHolder(val view:View): RecyclerView.ViewHolder(view){

}