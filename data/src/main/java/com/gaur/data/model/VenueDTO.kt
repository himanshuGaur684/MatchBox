package com.gaur.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VenueDTO(
    val allowMenuUrlEdit: Boolean,
    val beenHere: BeenHereDTO,
    val categories: List<CategoryDTO>,
    val contact: ContactDTO,
    val hasMenu: Boolean,
    val hasPerk: Boolean,
    val hereNow: HereNowDTO,
    val id: String,
    val location: LocationDTO,
    val menu: MenuDTO,
    val name: String,
    val referralId: String,
    val stats: StatsDTO,
    val storeId: String,
    val url: String,
    val venuePage: VenuePageDTO,
    val venueRatingBlacklisted: Boolean,
    val verified: Boolean
):Parcelable