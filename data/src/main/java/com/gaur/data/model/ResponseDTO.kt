package com.gaur.data.model

data class ResponseDTO(
    val confident: Boolean,
    val venues: List<VenueDTO>
)