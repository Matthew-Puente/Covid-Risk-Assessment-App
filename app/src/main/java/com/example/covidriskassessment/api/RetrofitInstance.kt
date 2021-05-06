package com.example.covidriskassessment.api

import com.example.covidriskassessment.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ResultApi by lazy {
        retrofit.create(ResultApi::class.java)
    }
}