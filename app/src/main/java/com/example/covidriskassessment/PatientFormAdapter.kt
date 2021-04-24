package com.example.covidriskassessment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class MainAdapter(val context: Context, var dataList:MutableList<String>):RecyclerView.Adapter<CustomViewHolder>(),
    AdapterView.OnItemSelectedListener {
    inner class patientHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            var spinner = view.spinner
            spinner.onItemSelectedListener=this@MainAdapter
        }
    }
        val Questions = listOf<String>(
            "Age?", "Gender?", "Ethnicity", "Asthma?",
            "Cardiovascular Disease?", "Chronic Lung Disease?",
            "Immune Suppression?", "Metabolic Disease?", "Neurologic Disease?",
            "Auto-Immune Disease?", "Liver Disease?", "Obesity?", "Pregnancy?",
            "Hypertension?"
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            val layoutInflater = LayoutInflater.from(parent?.context)
            val view = if (viewType == 0) {
                layoutInflater.inflate(R.layout.row_item, parent, false)
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
            var Question = Questions.get(position)
            holder.view.questionText.text = Question

            var spinner = holder.view.spinner


            //val submitButton = holder.view.findViewById<Button>(R.id.submitButton)
            //submitButton.setOnClickListener {
            // Submit button here i think
            //}

        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            TODO("Not yet implemented")
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            dataList.add(position, view?.spinner?.selectedItem.toString())
            view?.spinner?.questionText?.text = view?.spinner?.selectedItem.toString()
        }
    }



class CustomViewHolder(val view:View): RecyclerView.ViewHolder(view)



