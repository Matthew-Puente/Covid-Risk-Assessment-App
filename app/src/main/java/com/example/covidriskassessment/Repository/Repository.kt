package com.example.covidriskassessment.Repository

import com.example.covidriskassessment.Api.RetrofitInstance
import com.example.covidriskassessment.model.PatientData
import retrofit2.Response

class Repository {

    suspend fun getPatientResponse() : Response<PatientData> {
        return RetrofitInstance.api.getPatientResponse()
    }

    suspend fun postPatientData(patient: PatientData) : Response<PatientData> {
        return RetrofitInstance.api.postPatientData(patient)
    }
}