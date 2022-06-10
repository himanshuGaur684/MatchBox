package com.gaur.matchbox.saved_matches

import com.gaur.domain.model.Venue

data class SavedVenueState(
    val isLoading:Boolean = false,
    val error:String="",
    val data:List<Venue>?=null
)
