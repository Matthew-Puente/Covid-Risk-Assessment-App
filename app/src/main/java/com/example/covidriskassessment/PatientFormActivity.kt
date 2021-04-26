package com.example.covidriskassessment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PatientFormActivity : AppCompatActivity() {

    private lateinit var patientRecyclerView: RecyclerView
    private lateinit var submitButton: Button

    private val patientData: PatientData = PatientData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_form)

        submitButton = findViewById(R.id.submitButton)
        //TODO("IMPLEMENT CLICK LISTENER FOR SUBMIT BUTTON")

        patientRecyclerView = findViewById(R.id.recyclerView)
        patientRecyclerView.layoutManager = LinearLayoutManager(this)
        patientRecyclerView.adapter = PatientFormAdapter(this, patientData)

    }

}