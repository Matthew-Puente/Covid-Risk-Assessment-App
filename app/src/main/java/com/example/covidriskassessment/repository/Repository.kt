package com.example.covidriskassessment.repository

import com.example.covidriskassessment.api.RetrofitInstance
import com.example.covidriskassessment.model.PatientData
import retrofit2.Response

class Repository {

    suspend fun postPatientData(patient: PatientData) : Response<Int> {
        return RetrofitInstance.api.postPatientData(patient)
    }
}