package com.gaur.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactDTO(
    val facebook: String,
    val facebookName: String,
    val facebookUsername: String,
    val formattedPhone: String,
    val instagram: String,
    val phone: String,
    val twitter: String
):Parcelable