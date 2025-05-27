package com.example.mlacharacters.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mlacharacters.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val _characterList = MutableStateFlow<List<Character>>(emptyList())
    val characterList: StateFlow<List<Character>> = _characterList

    fun setCharacterList(characters: List<Character>) {
        viewModelScope.launch {
            Log.d("CharacterViewModel", "Data item masuk ke dalam list")
            _characterList.value = characters
        }
    }

    fun logItemClick(character: Character, action: String) {
        Log.d("CharacterViewModel", "Tombol $action ditekan untuk ${character.name}")
    }

    fun logNavigateDetail(character: Character) {
        Log.d("CharacterViewModel", "Navigasi ke detail karakter: ${character.name}")
    }
}
