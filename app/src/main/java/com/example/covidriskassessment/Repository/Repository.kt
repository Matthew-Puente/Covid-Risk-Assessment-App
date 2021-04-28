package com.example.covidriskassessment.Repository

import com.example.covidriskassessment.Api.RetrofitInstance
import com.example.covidriskassessment.model.AiResponse

class Repository {

    suspend fun getAiResponse() : AiResponse {
        return RetrofitInstance.api.getAiResponse()
    }
}