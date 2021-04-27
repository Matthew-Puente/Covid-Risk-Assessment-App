package com.example.covidriskassessment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView

private val TAG = "ADAPTER"

class PatientFormAdapter(private val context: Context, val patientData: PatientData):
    RecyclerView.Adapter<PatientFormAdapter.PatientHolder>() {

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

    inner class PatientHolder(itemView: View) : RecyclerView.ViewHolder(itemView), AdapterView.OnItemSelectedListener {

        val questionText: TextView = itemView.findViewById(R.id.questionText)
        val ageResponse: EditText? = itemView.findViewById(R.id.ageEditText)
        val genderSpinner: Spinner? = itemView.findViewById(R.id.gender_spinner)
        val ethnicitySpinner: Spinner? = itemView.findViewById(R.id.ethnicity_spinner)
        val yesNoSpinners: Spinner? = itemView.findViewById(R.id.spinner)


        init {
            genderSpinner?.onItemSelectedListener = this
            ethnicitySpinner?.onItemSelectedListener = this
            yesNoSpinners?.onItemSelectedListener = this
            // Bug when hitting arrow button more than once
            ageResponse?.addTextChangedListener{
                patientData.age = ageResponse.text.toString().toInt()
                Log.d(TAG, patientData.age.toString())
            }
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val answer = parent?.getItemAtPosition(position) as String
            when (adapterPosition) {
                1 -> patientData.gender = answer
                2 -> patientData.ethnicity = answer
                3 -> patientData.asthma = answer
                4 -> patientData.cardio = answer
                5 -> patientData.chronic = answer
                6 -> patientData.imSuppresion = answer
                7 -> patientData.metabolic = answer
                8 -> patientData.neurologic = answer
                9 -> patientData.autoImmune = answer
                10 -> patientData.liver = answer
                11 -> patientData.obesity = answer
                12 -> patientData.pregnancy = answer
                13 -> patientData.hyper = answer
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            // Intentionally left blank
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

    }
}







