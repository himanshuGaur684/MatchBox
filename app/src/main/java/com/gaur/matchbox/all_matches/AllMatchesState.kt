package com.gaur.matchbox.all_matches

import com.gaur.domain.model.Venue

data class AllMatchesState(
    val isLoading:Boolean=false,
    val error:String="",
    val data:List<Venue>?=null
)
