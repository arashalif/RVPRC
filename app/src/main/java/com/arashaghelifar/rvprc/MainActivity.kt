package com.arashaghelifar.rvprc

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.arashaghelifar.content.ContentScreen
import com.arashaghelifar.content.ContentViewModel

import com.arashaghelifar.edit.EditScreen
import com.arashaghelifar.edit.EditViewModel
import com.arashaghelifar.ui.route.Screen
import com.arashaghelifar.ui.theme.RVPRCTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = Color.WHITE
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            window.statusBarColor = Color.BLACK
        }
        super.onCreate(savedInstanceState)
        setContent {
            RVPRCTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ContentScreen.route
                    ) {
                        composable(Screen.ContentScreen.route) {
                            val viewModel: ContentViewModel = hiltViewModel()
                            ContentScreen(viewModel.contentState.value, navController)
                        }
                        composable(
                            Screen.EditScreen.route +"?title={title}&description={description}",
                            arguments = listOf(
                                navArgument("title") { type = NavType.StringType },
                                navArgument("description") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val viewModel: EditViewModel = hiltViewModel()
                            val titleInput = backStackEntry.arguments?.getString("title") ?: ""
                            val descriptionInput =
                                backStackEntry.arguments?.getString("description") ?: ""
                            viewModel.titleState.value = titleInput
                            viewModel.descriptionState.value = descriptionInput

                            EditScreen(
                                title = viewModel.titleState,
                                description = viewModel.descriptionState,
                                navController
                            ) {
                                viewModel.saveChanges()
                                navController.popBackStack()
                            }
                        }
                    }
                }
            }
        }
    }
}

