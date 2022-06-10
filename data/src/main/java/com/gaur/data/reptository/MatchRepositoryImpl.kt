package com.gaur.data.reptository

import android.util.Log
import com.gaur.common.SafeApiRequest
import com.gaur.data.network.ApiService
import com.gaur.data.room.MatchDAO
import com.gaur.domain.model.Venue
import com.gaur.domain.repository.MatchRepository

class MatchRepositoryImpl(private val apiService: ApiService,private val matchDAO: MatchDAO) : MatchRepository , SafeApiRequest(){
    override suspend fun getAllVenues(): List<Venue> {
        val response = safeApiRequest{ apiService.getAllMatches() }
        val matchDAO = matchDAO.getAllVenue()
        Log.d("TAG", "getAllVenues: ${response}")
        return response.response.venues.map { venueDto->
            Venue(
                name = venueDto.name,
                isSaved = matchDAO.any { it.id == venueDto.id },
                id = venueDto.id
            )
        }
    }

    override suspend fun getAllVenuesFromDatabase(): List<Venue> {
        return matchDAO.getAllVenue().map { Venue(id = it.id,name=it.name,isSaved = true) }
    }


    override suspend fun insertVenue(venue: Venue): List<Venue> {
        matchDAO.insertMatch(venue)
        return getAllVenues()
    }

    override suspend fun deleteVenue(venue: Venue): List<Venue> {
         matchDAO.deleteVenue(venue)
        return getAllVenues()
    }
}