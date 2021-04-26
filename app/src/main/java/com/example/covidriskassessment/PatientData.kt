package com.example.covidriskassessment

data class PatientData(var age:Int = 0,
                       var gender:String = "",
                       var ethnicity:String = "",
                       var asthma:String = "",
                       var cardio:String = "",
                       var chronic:String = "",
                       var imSuppresion:String = "",
                       var metabolic:String = "",
                       var neurologic:String = "",
                       var autoImmune:String = "",
                       var liver:String = "",
                       var obesity:String = "",
                       var pregnancy:String = "",
                       var renal:String = "",
                       var gastro:String = "",
                       var hyper:String = "",
                       var other:String = "")
