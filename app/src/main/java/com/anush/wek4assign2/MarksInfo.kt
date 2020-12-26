package com.anush.wek4assign2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable

class MarksInfo (
    val studentId: String?,
    val studentName:String?, val androidMarks: Double,
    val apiMarks: Double, val iotMarks: Double,
    val percentage:Double): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble()

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(studentId)
        parcel.writeString(studentName)
        parcel.writeDouble(androidMarks)
        parcel.writeDouble(apiMarks)
        parcel.writeDouble(iotMarks)
        parcel.writeDouble(percentage)


    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MarksInfo> {
        override fun createFromParcel(parcel: Parcel): MarksInfo {
            return MarksInfo(parcel)
        }

        override fun newArray(size: Int): Array<MarksInfo?> {
            return arrayOfNulls(size)
        }
    }
}



