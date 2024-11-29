package com.arashaghelifar.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import androidx.compose.runtime.rememberCoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    onEditClick: () -> Unit,
    onConnectClick: () -> Unit,
    onDeleteClick: () -> Unit,
    showBottomSheet: Boolean,
    onDismissRequest: () -> Unit
) {
    // Show the bottom sheet based on showBottomSheet state
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismissRequest, // Dismiss the bottom sheet when requested
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp), // Rounded corners
            containerColor = MaterialTheme.colorScheme.background, // Background color of the sheet
            tonalElevation = 8.dp // Elevation
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Bottom sheet options with corresponding click actions
                BottomSheetOption("Edit", onClick = onEditClick)
                BottomSheetOption("Connect more social media", onClick = onConnectClick)
                BottomSheetOption(
                    text = "Delete",
                    color = Color.Red, // Red color for Delete option
                    onClick = onDeleteClick
                )
                BottomSheetOption("Cancel") {
                    onDismissRequest() // Dismiss the bottom sheet when Cancel is clicked
                }
            }
        }
    }
}

@Composable
fun BottomSheetOption(
    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
    onClick: () -> Unit
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = color,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp)
    )
}
