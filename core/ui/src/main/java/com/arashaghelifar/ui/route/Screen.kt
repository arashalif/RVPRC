package com.arashaghelifar.ui.route

sealed class Screen(val route: String) {
    data object ContentScreen: Screen("content_screen")
    data object EditScreen: Screen("edit_screen")
}
