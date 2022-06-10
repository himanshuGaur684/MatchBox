package com.gaur.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gaur.data.model.VenueDTO
import com.gaur.domain.model.Venue


@Database(entities = [Venue::class], version = 1, exportSchema = false)
abstract class MatchDatabase :RoomDatabase(){


    companion object {
        fun getInstance(context: Context): MatchDatabase {
            return Room.databaseBuilder(context, MatchDatabase::class.java, "match").build()
        }
    }

    abstract fun getMatchDAO():MatchDAO


}