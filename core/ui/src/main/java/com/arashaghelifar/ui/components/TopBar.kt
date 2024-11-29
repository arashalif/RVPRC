package com.arashaghelifar.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RVTopBar(
    modifier: Modifier = Modifier,
    leftComponent: @Composable () -> Unit = {},
    rightComponent: @Composable () -> Unit = {},
    centerComponent: @Composable () -> Unit = {},
) {

    Row(
        modifier = Modifier
            .background(Color.White)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),

        verticalAlignment = CenterVertically
    ) {
        leftComponent()
        Box(modifier = Modifier.weight(1f))
        centerComponent()
        Box(modifier = Modifier.weight(1f))
        rightComponent()
    }

}