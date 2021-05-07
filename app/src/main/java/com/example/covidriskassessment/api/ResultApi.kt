package com.example.covidriskassessment.api

import com.example.covidriskassessment.model.PatientData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ResultApi {

    @POST("Production/patient")
    suspend fun postPatientData(@Body patient: PatientData) : Response<Int>
}