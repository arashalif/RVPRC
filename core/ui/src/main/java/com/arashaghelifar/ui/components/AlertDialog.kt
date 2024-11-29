package com.arashaghelifar.ui.components

import android.app.AlertDialog
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AlertDialog(
    onDelete: () -> Unit,
    onCancel: () -> Unit
) {

        AlertDialog(
            onDismissRequest = { onCancel() }, // Close the dialog when touched outside
            title = {
                Text(text = "Delete Post")
            },
            text = {
                Text("Are you sure you want to delete this post?")
            },
            confirmButton = {
                Button(onClick = { onDelete() }) {
                    Text("Delete")
                }
            },
            dismissButton = {
                Button(onClick = { onCancel() }) {
                    Text("Cancel")
                }
            }
        )
    }


@Preview
@Composable
fun DeletePostDialogPreview() {
    AlertDialog(
        onDelete = { /* Delete logic here */ },
        onCancel = { /* Cancel logic here */ }
    )
}
