package com.example.covidriskassessment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covidriskassessment.model.PatientData
import com.example.covidriskassessment.model.SpinnerItem

class PatientFormActivity : AppCompatActivity() {

    private lateinit var patientRecyclerView: RecyclerView
    private lateinit var submitButton: Button

    private val patientData: PatientData = PatientData()
    private val questions = listOf("Please answer the following:", "Age:", "Sex:",
    "Patient type:", "Tobacco use:", "Currently in ICU:", "Placed on ventilator:",
    "Known recent contact with other covid patient:",
    "Is the patient known to have any of the following conditions?", "Immune Suppression:",
    "COPD:", "Diabetes", "Kidney failure:", "Obesity:", "Pregnant:", "Hypertension:",
    "Asthma:", "Cardiovascular disease:", "Pneumonia:", "Other:")

    private var items = mutableListOf<SpinnerItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_form)

        initializeItems()
        patientRecyclerView = findViewById(R.id.recyclerView)
        patientRecyclerView.layoutManager = LinearLayoutManager(this)
        patientRecyclerView.adapter = PatientFormAdapter(this, patientData, items)

        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            if (!patientData.containsNull()) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("patientData", patientData)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun initializeItems() {
        for (element in questions) {
            items.add(SpinnerItem(element))
        }
    }
}