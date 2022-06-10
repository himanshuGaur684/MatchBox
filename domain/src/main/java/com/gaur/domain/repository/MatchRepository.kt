package com.gaur.domain.repository

import com.gaur.domain.model.Venue

interface MatchRepository {


    suspend fun getAllVenues():List<Venue>

    suspend fun getAllVenuesFromDatabase():List<Venue>

    suspend fun insertVenue(venue:Venue) :List<Venue>

    suspend fun deleteVenue(venue: Venue) : List<Venue>

}