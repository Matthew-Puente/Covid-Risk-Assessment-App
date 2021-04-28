package com.example.covidriskassessment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covidriskassessment.Repository.Repository
import com.example.covidriskassessment.model.AiResponse
import kotlinx.coroutines.launch

class ResultViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<AiResponse> = MutableLiveData()

    fun getResponse() {
        viewModelScope.launch {
            val response: AiResponse = repository.getAiResponse()
            myResponse.value = response
        }
    }
}