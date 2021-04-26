package com.example.covidriskassessment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PatientFormActivity : AppCompatActivity() {

    private lateinit var patientRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_form)

        patientRecyclerView = findViewById(R.id.recyclerView)
        patientRecyclerView.layoutManager = LinearLayoutManager(this)
        patientRecyclerView.adapter = PatientFormAdapter(this)

    }

//    fun getViewHolder(): MutableList<String> {
//        val patientFormViewModel:PatientFormViewModel by viewModels()
//        return patientFormViewModel.getData()
//    }
}