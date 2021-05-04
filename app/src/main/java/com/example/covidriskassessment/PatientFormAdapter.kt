package com.example.covidriskassessment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.covidriskassessment.model.PatientData

private val TAG = "ADAPTER"

class PatientFormAdapter(private val context: Context, val patientData: PatientData):
    RecyclerView.Adapter<PatientFormAdapter.PatientHolder>() {

    // Need to be updated
    private val questions = listOf(
        "Age?", "Gender?", "In Patient?", "Asthma?",
        "Cardiovascular Disease?", "Chronic Lung Disease?",
        "Immune Suppression?", "Metabolic Disease?", "Neurologic Disease?",
        "Auto-Immune Disease?", "Liver Disease?", "Obesity?", "Pregnancy?",
        "Hypertension?", "15", "16", "17", "18"
    )

    private val genderAdapter = ArrayAdapter.createFromResource(context, R.array.Gender, android.R.layout.simple_spinner_item)
    private val yesNoAdapter = ArrayAdapter.createFromResource(context, R.array.YN, android.R.layout.simple_spinner_item)

    inner class PatientHolder(itemView: View) : RecyclerView.ViewHolder(itemView), AdapterView.OnItemSelectedListener {

        val questionText: TextView = itemView.findViewById(R.id.questionText)
        val ageResponse: EditText? = itemView.findViewById(R.id.ageEditText)
        val genderSpinner: Spinner? = itemView.findViewById(R.id.gender_spinner)
        val yesNoSpinners: Spinner? = itemView.findViewById(R.id.spinner)


        init {
            genderSpinner?.onItemSelectedListener = this
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
                1 -> patientData.sex = if (answer == "Female") 1 else if (answer == "Male") 2 else 0
                2 -> patientData.patient_type = if (answer == "Outpatient") 1 else if (answer == "Inpatient") 2 else 0
                3 -> patientData.asthma = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                4 -> patientData.cardiovascular = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                5 -> patientData.renal_chronic = if (answer == "yes") 1 else if (answer == "No") 2 else 0
                6 -> patientData.inmsupr = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                7 -> patientData.copd = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                8 -> patientData.diabetes = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                9 -> patientData.intubed = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                10 -> patientData.tobacco = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                11 -> patientData.obesity = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                12 -> patientData.pregnancy = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                13 -> patientData.hypertension = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                14 -> patientData.contact_other_covid = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                15 -> patientData.icu = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                16 -> patientData.other_disease = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                17 -> patientData.pneumonia = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
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
            else  -> layoutInflater.inflate(R.layout.gender_row_item, parent, false)
        }
        return PatientHolder(view)
    }

    override fun getItemCount(): Int = questions.size

    override fun getItemViewType(position: Int): Int {
        return when(questions[position]) {
            "Age?" -> 1
            "Gender?" -> 2
            else -> 0
        }
    }

    override fun onBindViewHolder(holder: PatientHolder, position: Int) {
        val question = questions[position]
        holder.questionText.text = question
        holder.genderSpinner?.adapter = genderAdapter
        holder.yesNoSpinners?.adapter = yesNoAdapter

    }
}







