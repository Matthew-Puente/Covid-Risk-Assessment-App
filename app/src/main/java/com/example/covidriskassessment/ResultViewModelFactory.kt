package com.example.covidriskassessment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.covidriskassessment.repository.Repository

class ResultViewModelFactory(
        private val repository: Repository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return ResultViewModel(repository) as T
    }


}