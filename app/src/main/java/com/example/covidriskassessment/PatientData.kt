package com.example.covidriskassessment

data class PatientData(var age:Int = -1,
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
                       var other:String = "") {

    fun containsNull() : Boolean {
        if (age == -1) return true
        if (gender == "") return true
        if (ethnicity == "") return true
        if (asthma == "") return true
        if (cardio == "") return true
        if (chronic == "") return true
        if (imSuppresion == "") return true
        if (metabolic == "") return true
        if (neurologic == "") return true
        if (autoImmune == "") return true
        if (liver == "") return true
        if (obesity == "") return true
        if (pregnancy == "") return true
        if (renal == "") return true
        if (gastro == "") return true
        if (hyper == "") return true
        if (other == "") return true
        return false
    }
}
