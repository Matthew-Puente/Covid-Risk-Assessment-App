package com.example.covidriskassessment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.covidriskassessment.model.PatientData
import com.example.covidriskassessment.model.SpinnerItem

private const val TAG = "ADAPTER"

class PatientFormAdapter(private val context: Context, val patientData: PatientData,
                         private val items: List<SpinnerItem>):
    RecyclerView.Adapter<PatientFormAdapter.PatientHolder>() {

    private val genderAdapter = ArrayAdapter.createFromResource(context, R.array.Gender, android.R.layout.simple_spinner_item)
    private val yesNoAdapter = ArrayAdapter.createFromResource(context, R.array.YN, android.R.layout.simple_spinner_item)
    private val patientTypeAdapter = ArrayAdapter.createFromResource(context, R.array.InOut, android.R.layout.simple_spinner_item)

    inner class PatientHolder(itemView: View) : RecyclerView.ViewHolder(itemView), AdapterView.OnItemSelectedListener {

        val questionText: TextView = itemView.findViewById(R.id.questionText)
        val ageResponse: EditText? = itemView.findViewById(R.id.ageEditText)
        val genderSpinner: Spinner? = itemView.findViewById(R.id.gender_spinner)
        val yesNoSpinners: Spinner? = itemView.findViewById(R.id.spinner)
        val patientTypeSpinner: Spinner? = itemView.findViewById(R.id.type_spinner)

        init {
            genderAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            yesNoAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            patientTypeAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
            genderSpinner?.adapter = genderAdapter
            yesNoSpinners?.adapter = yesNoAdapter
            patientTypeSpinner?.adapter = patientTypeAdapter
            genderSpinner?.onItemSelectedListener = this
            yesNoSpinners?.onItemSelectedListener = this
            patientTypeSpinner?.onItemSelectedListener = this

           ageResponse?.setOnClickListener {
                if (ageResponse.text.toString() != "") {
                    patientData.age = ageResponse.text.toString().toInt()
                    closeKeyboard(ageResponse)
                }
            }
        }

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val answer = parent?.getItemAtPosition(position) as String
            when (adapterPosition) {
                // 0 -> answer the following
                // 1 -> age edit text
                2 -> patientData.sex = if (answer == "Female") 1 else if (answer == "Male") 2 else 0
                3 -> patientData.patient_type = if (answer == "In-patient") 1 else if (answer == "Out-patient") 2 else 0
                4 -> patientData.tobacco = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                5 -> patientData.icu = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                6 -> patientData.intubed = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                7 -> patientData.contact_other_covid = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                // 8 -> any conditions?
                9 -> patientData.inmsupr = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                10 -> patientData.copd = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                11 -> patientData.diabetes = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                12 -> patientData.renal_chronic = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                13 -> patientData.obesity = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                14 -> patientData.pregnancy = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                15 -> patientData.hypertension = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                16 -> patientData.asthma = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                17 -> patientData.cardiovascular = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                18 -> patientData.pneumonia = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                19 -> patientData.covid_res = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
                20 -> patientData.other_disease = if (answer == "Yes") 1 else if (answer == "No") 2 else 0
            }
            items[adapterPosition].position = position
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
            // Intentionally left blank
        }
    }

    private fun closeKeyboard(view: View) {
        val imm: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = when (viewType) {
            1 -> layoutInflater.inflate(R.layout.age_row_item, parent, false)
            2 -> layoutInflater.inflate(R.layout.gender_row_item, parent, false)
            3 -> layoutInflater.inflate(R.layout.helper_row_item, parent, false)
            4 -> layoutInflater.inflate(R.layout.patient_type_row_item, parent, false)
            5 -> layoutInflater.inflate(R.layout.preconditions_row_item, parent, false)
            else  -> layoutInflater.inflate(R.layout.row_item, parent, false)
        }
        return PatientHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when(items[position].question) {
            "Age:" -> 1
            "Sex:" -> 2
            "Please answer the following:" -> 3
            "Patient type:" -> 4
            "Is the patient known to have any of the following conditions?" -> 5
            else -> 0
        }
    }

    override fun onBindViewHolder(holder: PatientHolder, position: Int) {
        val item = items[position]
        holder.questionText.text = item.question
        if (position == 2) {
            holder.genderSpinner?.setSelection(item.position)
        }
        else if (position == 3) {
            holder.patientTypeSpinner?.setSelection(item.position)
        }
        else if (position > 3 && position != 8) {
            holder.yesNoSpinners?.setSelection(item.position)
        }
    }
}








