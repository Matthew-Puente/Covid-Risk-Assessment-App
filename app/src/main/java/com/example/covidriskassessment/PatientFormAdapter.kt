package com.example.covidriskassessment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*

private val TAG = "ADAPTER"

class PatientFormAdapter(val context: Context/* , var dataList:MutableList<String>*/):
    RecyclerView.Adapter<PatientFormAdapter.PatientHolder>(), AdapterView.OnItemSelectedListener {

    private val questions = listOf(
        "Age?", "Gender?", "Ethnicity", "Asthma?",
        "Cardiovascular Disease?", "Chronic Lung Disease?",
        "Immune Suppression?", "Metabolic Disease?", "Neurologic Disease?",
        "Auto-Immune Disease?", "Liver Disease?", "Obesity?", "Pregnancy?",
        "Hypertension?"
    )
    private val genderAdapter = ArrayAdapter.createFromResource(context, R.array.Gender, android.R.layout.simple_spinner_item)
    private val ethnicityAdapter = ArrayAdapter.createFromResource(context, R.array.Ethnicity, android.R.layout.simple_spinner_item)
    private val yesNoAdapter = ArrayAdapter.createFromResource(context, R.array.YNU, android.R.layout.simple_spinner_item)

    inner class PatientHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val questionText: TextView = itemView.findViewById(R.id.questionText)

        val genderSpinner: Spinner? = itemView.findViewById(R.id.gender_spinner)
        val ethnicitySpinner: Spinner? = itemView.findViewById(R.id.ethnicity_spinner)
        val yesNoSpinners: Spinner? = itemView.findViewById(R.id.spinner)

        init {
            genderSpinner?.onItemSelectedListener = this@PatientFormAdapter
            ethnicitySpinner?.onItemSelectedListener = this@PatientFormAdapter
            yesNoSpinners?.onItemSelectedListener = this@PatientFormAdapter
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = when (viewType) {
            0 -> layoutInflater.inflate(R.layout.row_item, parent, false)
            1 -> layoutInflater.inflate(R.layout.age_row_item, parent, false)
            2 -> layoutInflater.inflate(R.layout.gender_row_item, parent, false)
            else -> layoutInflater.inflate(R.layout.ethnicity_row_item, parent, false)
        }
        return PatientHolder(view)
    }

    // # of items
    override fun getItemCount(): Int = questions.size

    override fun getItemViewType(position: Int): Int {
        return when(questions[position]) {
            "Age?" -> 1
            "Gender?" -> 2
            "Ethnicity" -> 3
            else -> 0
        }
    }


    override fun onBindViewHolder(holder: PatientHolder, position: Int) {
        val question = questions[position]
        holder.questionText.text = question
        holder.genderSpinner?.adapter = genderAdapter
        holder.ethnicitySpinner?.adapter = ethnicityAdapter
        holder.yesNoSpinners?.adapter = yesNoAdapter

        //var spinner = holder.view.spinner


        //val submitButton = holder.view.findViewById<Button>(R.id.submitButton)
        //submitButton.setOnClickListener {
        // Submit button here i think
        //}

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val spin = parent?.getItemAtPosition(position) as String

        val pos = parent.id
        Log.d(TAG, spin + " " + pos)
        //dataList.add(position, view?.spinner?.selectedItem.toString())
        //view?.spinner?.questionText?.text = view?.spinner?.selectedItem.toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}







