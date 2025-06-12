package com.example.mladventure.data.remote

import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun getCharacters(): List<CharacterDto>

    companion object {
        const val BASE_URL = "https://mlacharacters.free.beeceptor.com/data"
    }
}
