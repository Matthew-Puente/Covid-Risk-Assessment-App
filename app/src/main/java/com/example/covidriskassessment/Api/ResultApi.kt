package com.example.covidriskassessment.Api

import com.example.covidriskassessment.model.AiResponse
import retrofit2.http.GET

interface ResultApi {

    @GET("Production/patient")
    suspend fun getAiResponse() : AiResponse
}