package com.example.covidriskassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.covidriskassessment.model.PatientData
import com.example.covidriskassessment.Repository.Repository

class ResultActivity : AppCompatActivity() {

    private lateinit var resultViewModel: ResultViewModel
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val patientData = this.intent.getParcelableExtra<PatientData>("patientData")
        val repository = Repository()
        val resultViewModelFactory = ResultViewModelFactory(repository)

        resultViewModel = ViewModelProvider(this, resultViewModelFactory).get(ResultViewModel::class.java)

        if (patientData != null) {
            resultViewModel.postPatientData(patientData)
        }

        resultViewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body()?.age.toString())
                Log.d("Response", response.body()?.sex.toString())
            } else {
                Log.d("Response", response.errorBody().toString())
            }
        })
    }
}