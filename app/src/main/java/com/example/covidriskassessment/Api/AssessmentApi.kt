package com.example.covidriskassessment.Api

import retrofit2.http.GET

interface AssessmentApi {

    @GET("Production/patient")
    fun getPOST()
}