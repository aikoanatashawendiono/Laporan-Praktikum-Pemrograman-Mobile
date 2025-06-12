package com.example.mladventure.repository

import com.example.mladventure.data.local.CharacterDao
import com.example.mladventure.data.local.CharacterEntity
import com.example.mladventure.data.remote.CharacterApi
import kotlinx.coroutines.flow.Flow

class CharacterRepository(
    private val api: CharacterApi,
    private val dao: CharacterDao
) {
    val characters: Flow<List<CharacterEntity>> = dao.getAll()

    suspend fun refreshCharacters() {
        try {
            val dtoList = api.getCharacters()
            val entities = dtoList.map {
                CharacterEntity(
                    name = it.name,
                    alias = it.alias,
                    imageUrl = it.imageUrl,
                    description = it.description,
                    wikiUrl = it.wikiUrl
                )
            }
            dao.insertAll(entities)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun toggleFavorite(character: CharacterEntity) {
        dao.update(character.copy(isFavorite = !character.isFavorite))
    }
}
