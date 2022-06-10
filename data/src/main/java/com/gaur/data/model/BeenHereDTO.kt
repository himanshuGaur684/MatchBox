package com.gaur.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BeenHereDTO(
    val lastCheckinExpiredAt: Int
):Parcelable