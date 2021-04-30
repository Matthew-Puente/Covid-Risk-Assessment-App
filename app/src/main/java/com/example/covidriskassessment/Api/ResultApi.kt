package com.example.covidriskassessment.Api

import com.example.covidriskassessment.PatientData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ResultApi {

    @GET("Production/patient")
    suspend fun getPatientResponse() : PatientData

    @POST("Production/patient")
    suspend fun postPatientData(@Body patient: PatientData) : PatientData
}