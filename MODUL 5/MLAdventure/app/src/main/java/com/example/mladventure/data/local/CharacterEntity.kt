package com.example.mladventure.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey val name: String,
    val alias: String,
    val imageUrl: String,
    val description: String,
    val wikiUrl: String,
    val isFavorite: Boolean = false
)
