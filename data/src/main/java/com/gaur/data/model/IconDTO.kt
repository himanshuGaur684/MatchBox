package com.gaur.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IconDTO(
    val prefix: String,
    val suffix: String
):Parcelable