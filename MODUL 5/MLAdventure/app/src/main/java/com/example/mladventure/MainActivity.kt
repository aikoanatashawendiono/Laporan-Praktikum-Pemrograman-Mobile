package com.example.mladventure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.mladventure.ui.theme.CharacterViewModel
import com.example.mladventure.ui.theme.CharacterViewModelFactory
import com.example.mladventure.ui.theme.MLACharactersTheme
import com.example.mladventure.data.datastore.ThemePreferenceManager
import kotlinx.coroutines.flow.first
import androidx.compose.runtime.*
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    private lateinit var themeManager: ThemePreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        themeManager = ThemePreferenceManager(applicationContext)

        setContent {
            val isDarkMode by themeManager.isDarkMode.collectAsState(initial = false)

            MLACharactersTheme(darkTheme = isDarkMode) {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    val viewModel: CharacterViewModel = viewModel(
                        factory = CharacterViewModelFactory()
                    )

                    NavGraph(
                        navController = navController,
                        viewModel = viewModel,
                        isDarkMode = isDarkMode,
                        onToggleTheme = { enabled ->
                            runBlocking {
                                themeManager.setDarkMode(enabled)
                            }
                        }
                    )
                }
            }
        }
    }
}
