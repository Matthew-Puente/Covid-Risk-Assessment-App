package com.example.covidriskassessment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covidriskassessment.model.AiResponse
import com.example.covidriskassessment.model.PatientData
import com.example.covidriskassessment.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ResultViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Int>> = MutableLiveData()

    fun postPatientData(patient: PatientData) {
        viewModelScope.launch {
            val response = repository.postPatientData(patient)
            myResponse.value = response
        }
    }

    fun getResponse() {
        viewModelScope.launch {
            val response = repository.getPatientResponse()
            myResponse.value = response
        }
    }
}