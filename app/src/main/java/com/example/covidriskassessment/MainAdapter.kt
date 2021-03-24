package com.example.covidriskassessment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class MainAdapter:RecyclerView.Adapter<CustomViewHolder>(){
    val Questions = listOf<String>("Age?", "Gender?", "Ethnicity", "Asthma?","Cardiovascular Disease?","Chronic Lung Disease?","Immune Suppression?","Metabolic Disease?","Neurologic Disease?","Auto-Immune Disease?","Liver Disease?","Obesity?","Pregnancy?","Hypertension?")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val view = if (viewType == 0) {
            layoutInflater.inflate(R.layout.row_item,parent,false)
        } else if (viewType == 1) {
            layoutInflater.inflate(R.layout.age_row_item, parent, false)
        } else if (viewType == 2) {
            layoutInflater.inflate(R.layout.gender_row_item, parent, false)
        } else {
            layoutInflater.inflate(R.layout.ethnicity_row_item, parent, false)
        }
        return CustomViewHolder(view)
    }
    // # of items
    override fun getItemCount(): Int {
        return Questions.size
    }

    override fun getItemViewType(position: Int): Int {
        if (Questions.get(position) == "Age?") {
            return 1
        } else if (Questions.get(position) == "Gender?") {
            return 2
        } else if (Questions.get(position) == "Ethnicity") {
            return 3
        } else {
            return 0
        }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val Question = Questions.get(position)
        holder?.view?.textView2?.text = Question

    }
}

class CustomViewHolder(val view:View): RecyclerView.ViewHolder(view){

}