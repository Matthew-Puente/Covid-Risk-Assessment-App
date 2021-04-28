package com.example.covidriskassessment.model

data class AiResponse( val id: String,
                       val name: String,
                       val sex: Int,
                       val patient_type: Int,
                       val date_Of_Entry: String,
                       val date_Of_First_Symptoms: String,
                       val intubed: Int,
                       val pneumonia: Int,
                       val age: Int,
                       val pregnancy: Int
)
