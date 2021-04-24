package com.example.covidriskassessment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

class PatientFormAdapter(/*val context: Context , var dataList:MutableList<String>*/):
    RecyclerView.Adapter<PatientFormAdapter.PatientHolder>() /*,AdapterView.OnItemSelectedListener*/ {

    private val questions = listOf(
        "Age?", "Gender?", "Ethnicity", "Asthma?",
        "Cardiovascular Disease?", "Chronic Lung Disease?",
        "Immune Suppression?", "Metabolic Disease?", "Neurologic Disease?",
        "Auto-Immune Disease?", "Liver Disease?", "Obesity?", "Pregnancy?",
        "Hypertension?"
    )

    inner class PatientHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val questionText: TextView = itemView.findViewById(R.id.questionText)
        val spinner: Spinner = itemView.findViewById(R.id.spinner)

        init {
            //spinner.onItemSelectedListener=@PatientFormAdapter
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientHolder {
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
        return PatientHolder(view)
    }

    // # of items
    override fun getItemCount(): Int {
        return questions.size
    }

    override fun getItemViewType(position: Int): Int {
        if (questions[position] == "Age?") {
            return 1
        } else if (questions[position] == "Gender?") {
            return 2
        } else if (questions[position] == "Ethnicity") {
            return 3
        } else {
            return 0
        }
    }


    override fun onBindViewHolder(holder: PatientHolder, position: Int) {
        val question = questions[position]
        holder.questionText.text = question

        //var spinner = holder.view.spinner


        //val submitButton = holder.view.findViewById<Button>(R.id.submitButton)
        //submitButton.setOnClickListener {
        // Submit button here i think
        //}

    }

//    override fun onNothingSelected(parent: AdapterView<*>?) {
//        TODO("Not yet implemented")
//    }
//
//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        dataList.add(position, view?.spinner?.selectedItem.toString())
//        view?.spinner?.questionText?.text = view?.spinner?.selectedItem.toString()
//    }
}







