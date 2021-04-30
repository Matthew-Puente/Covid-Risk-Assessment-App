package com.example.covidriskassessment.Repository

import com.example.covidriskassessment.Api.RetrofitInstance
import com.example.covidriskassessment.PatientData

class Repository {

    suspend fun getPatientResponse() : PatientData {
        return RetrofitInstance.api.getPatientResponse()
    }

    suspend fun postPatientData(patient:PatientData) : PatientData {
        return RetrofitInstance.api.postPatientData(patient)
    }
}