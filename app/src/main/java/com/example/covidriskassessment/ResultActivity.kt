package com.example.covidriskassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.covidriskassessment.Repository.Repository

class ResultActivity : AppCompatActivity() {

    private lateinit var resultViewModel: ResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val patient = PatientData(5, 3, 1, 1, 3)
        val repository = Repository()
        val resultViewModelFactory = ResultViewModelFactory(repository)
        resultViewModel = ViewModelProvider(this, resultViewModelFactory).get(ResultViewModel::class.java)
        //resultViewModel.getResponse()
        resultViewModel.postPatientData(patient)
        resultViewModel.myResponse.observe(this, Observer { response ->
            Log.d("Response", response.sex.toString())
        })
    }
}