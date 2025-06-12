package com.example.mladventure.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val name: String,
    val alias: String,
    val imageUrl: String,
    val description: String,
    val wikiUrl: String
)
