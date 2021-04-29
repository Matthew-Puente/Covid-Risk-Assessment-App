package com.example.covidriskassessment

data class PatientData( var sex:Int = 0,
                        var patient_type: Int = 0,
                        var intubed: Int = 0,
                        var pneumonia: Int = 0,
                        var age: Int = -1,
                        var pregnancy: Int = 0,
                        var diabetes: Int = 0,
                        var copd: Int = 0,
                        var asthma: Int = 0,
                        var inmsupr: Int = 0,
                        var hypertension: Int = 0,
                        var other_disease: Int = 0,
                        var cardiovascular: Int = 0,
                        var obesity: Int = 0,
                        var renal_chronic: Int = 0,
                        var tobacco: Int = 0,
                        var contact_other_covid: Int = 0,
                        var icu: Int = 0
) {
    fun containsNull() : Boolean {
        if (age == -1) return true
        if (sex == 0) return true
        if (patient_type == 0) return true
        if (intubed == 0) return true
        if (pneumonia == 0) return true
        if (diabetes == 0) return true
        if (copd == 0) return true
        if (asthma == 0) return true
        if (inmsupr == 0) return true
        if (other_disease == 0) return true
        if (cardiovascular == 0) return true
        if (obesity == 0) return true
        if (renal_chronic == 0) return true
        if (tobacco == 0) return true
        if (icu == 0) return true
        if (contact_other_covid == 0) return true
        if (pregnancy == 0) return true
        if (hypertension == 0) return true
        return false
    }
}
