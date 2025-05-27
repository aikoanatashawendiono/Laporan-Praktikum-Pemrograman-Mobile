package com.example.mlacharacters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.mlacharacters.ui.CharacterViewModel
import com.example.mlacharacters.ui.CharacterViewModelFactory
import com.example.mlacharacters.ui.theme.MLACharactersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MLACharactersTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()

                    val viewModel: CharacterViewModel = viewModel(
                        factory = CharacterViewModelFactory()
                    )

                    NavGraph(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}
