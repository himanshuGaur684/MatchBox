package com.gaur.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Venue(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val name:String,
    var isSaved:Boolean
)
