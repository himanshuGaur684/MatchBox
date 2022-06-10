package com.gaur.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HereNowDTO(
    val count: Int,
    val summary: String
):Parcelable