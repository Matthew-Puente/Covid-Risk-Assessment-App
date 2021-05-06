package com.example.covidriskassessment.model

import android.os.Parcel
import android.os.Parcelable

data class PatientData(var sex:Int = 0,
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
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt())

    fun containsNull() : Boolean {
        if (age == -1) return true
        if (sex == 0) return true
        if (patient_type == 0) return true
        if (asthma == 0) return true
        if (cardiovascular == 0) return true
        if (renal_chronic == 0) return true
        if (inmsupr == 0) return true
        if (copd == 0) return true
        if (diabetes == 0) return true
        if (intubed == 0) return true
        if (tobacco == 0) return true
        if (obesity == 0) return true
        if (pregnancy == 0) return true
        if (hypertension == 0) return true
        if (contact_other_covid == 0) return true
        if (icu == 0) return true
        if (other_disease == 0) return true
        if (pneumonia == 0) return true
        return false
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(sex)
        parcel.writeInt(patient_type)
        parcel.writeInt(intubed)
        parcel.writeInt(pneumonia)
        parcel.writeInt(age)
        parcel.writeInt(pregnancy)
        parcel.writeInt(diabetes)
        parcel.writeInt(copd)
        parcel.writeInt(asthma)
        parcel.writeInt(inmsupr)
        parcel.writeInt(hypertension)
        parcel.writeInt(other_disease)
        parcel.writeInt(cardiovascular)
        parcel.writeInt(obesity)
        parcel.writeInt(renal_chronic)
        parcel.writeInt(tobacco)
        parcel.writeInt(contact_other_covid)
        parcel.writeInt(icu)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PatientData> {
        override fun createFromParcel(parcel: Parcel): PatientData {
            return PatientData(parcel)
        }

        override fun newArray(size: Int): Array<PatientData?> {
            return arrayOfNulls(size)
        }
    }
}
