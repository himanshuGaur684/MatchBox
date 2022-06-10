package com.gaur.data.room

import androidx.room.*
import com.gaur.data.model.VenueDTO
import com.gaur.domain.model.Venue

@Dao
interface MatchDAO {



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMatch(venue: Venue)

    @Query("SELECT * FROM Venue")
    suspend fun getAllVenue():List<Venue>

    @Delete
    suspend fun deleteVenue(venue: Venue)






}