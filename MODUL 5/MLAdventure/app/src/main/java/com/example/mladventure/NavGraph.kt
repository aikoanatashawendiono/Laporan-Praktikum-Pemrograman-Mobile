package com.example.mladventure

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mladventure.ui.theme.CharacterViewModel
import com.example.mladventure.CharacterListScreen
import com.example.mladventure.ui.theme.CharacterDetailScreen
import com.example.mladventure.settings.SettingsScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: CharacterViewModel,
    isDarkMode: Boolean,
    onToggleTheme: (Boolean) -> Unit
) {
    val charactersState = viewModel.characterList.collectAsState()
    val characters = charactersState.value

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            CharacterListScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

        composable("detail/{name}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val character = characters.find { it.name == name }
            character?.let {
                CharacterDetailScreen(
                    character = it,
                    navController = navController
                )
            }
        }

        composable("settings") {
            SettingsScreen(
                isDarkMode = isDarkMode,
                onToggleTheme = onToggleTheme
            )
        }
    }
}
