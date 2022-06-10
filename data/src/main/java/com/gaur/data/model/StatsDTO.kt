package com.gaur.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatsDTO(
    val checkinsCount: Int,
    val tipCount: Int,
    val usersCount: Int
):Parcelable