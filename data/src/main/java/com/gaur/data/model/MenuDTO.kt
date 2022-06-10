package com.gaur.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MenuDTO(
    val anchor: String,
    val label: String,
    val mobileUrl: String,
    val type: String,
    val url: String
):Parcelable