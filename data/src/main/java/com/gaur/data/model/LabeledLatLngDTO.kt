package com.gaur.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LabeledLatLngDTO(
    val label: String,
    val lat: Double,
    val lng: Double
):Parcelable