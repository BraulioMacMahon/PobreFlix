package com.example.pobreflix.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val releaseDate: String,
    val description: String,
    val imageResId: String,
    val category: String,
    val ranking: Float
)


