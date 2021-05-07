package com.example.covidriskassessment.api

import com.example.covidriskassessment.model.AiResponse
import com.example.covidriskassessment.model.PatientData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ResultApi {

    @GET("Production/patient")
    suspend fun getPatientResponse() : Response<Int>

    @POST("Production/patient")
    suspend fun postPatientData(@Body patient: PatientData) : Response<Int>
}