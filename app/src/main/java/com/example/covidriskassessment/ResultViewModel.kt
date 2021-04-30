package com.example.covidriskassessment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covidriskassessment.Repository.Repository
import kotlinx.coroutines.launch

class ResultViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<PatientData> = MutableLiveData()

    fun postPatientData(patient: PatientData) {
        viewModelScope.launch {
            val response: PatientData = repository.postPatientData(patient)
            myResponse.value = response
        }
    }

    fun getResponse() {
        viewModelScope.launch {
            val response: PatientData = repository.getPatientResponse()
            myResponse.value = response
        }
    }
}