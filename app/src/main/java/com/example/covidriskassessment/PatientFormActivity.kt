package com.example.covidriskassessment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.covidriskassessment.model.PatientData

class PatientFormActivity : AppCompatActivity() {

    private lateinit var patientRecyclerView: RecyclerView
    private lateinit var submitButton: Button

    private val patientData: PatientData = PatientData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_form)

        patientRecyclerView = findViewById(R.id.recyclerView)
        patientRecyclerView.layoutManager = LinearLayoutManager(this)
        patientRecyclerView.adapter = PatientFormAdapter(this, patientData)

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

}