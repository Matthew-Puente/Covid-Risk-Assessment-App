package com.example.covidriskassessment

import androidx.lifecycle.ViewModel

class PatientFormViewModel: ViewModel() {
    private val datas = mutableListOf<String>()

    fun addData(data: String,position:Int ){
        datas.add(position,data)
    }
    fun getData(position: Int): String {
        return datas[position]
    }
    fun getData():MutableList<String>
    {
        return datas
    }
    fun clearData() {
        datas.clear()
    }
}