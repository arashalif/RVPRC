package com.arashaghelifar.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arashaghelifar.repository.model.ResultState
import com.arashaghelifar.ui.components.RVTopBar
import com.arashaghelifar.ui.theme.Primary
import com.arashaghelifar.ui.theme.Second


@Composable
fun EditScreen(
    title: MutableState<String>,
    description: MutableState<String>,
    navController: NavController,
    onSaveClicked: () -> Unit,
) {
    Edit(
        title = title,
        description = description,
        onCancelClicked = { navController.popBackStack() },
        onSaveClicked = {
            onSaveClicked()
        }
    )
}

@Composable
private fun Edit(
    title: MutableState<String>,
    description: MutableState<String>,
    onCancelClicked: () -> Unit,
    onSaveClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            RVTopBar(
                leftComponent = {
                    Text(
                        text = "Cancel",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Second,
                        modifier = Modifier
                            .clickable { onCancelClicked() }
                            .padding(horizontal = 16.dp)
                    )
                },
                centerComponent = {
                    Text(
                        "Edit",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                },
                rightComponent = {
                    Text(
                        text = "Save",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Second,
                        modifier = Modifier
                            .clickable {
                                onSaveClicked()
                            }
                            .padding(horizontal = 16.dp)
                    )
                }
            )
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                EditBody(
                    title = title,
                    description = description
                )
            }
        }
    )
}

@Composable
private fun EditBody(
    title: MutableState<String>,
    description: MutableState<String>,
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 18.dp)
    ) {

        Text(
            text = "EDIT TITLE OF YOUR VIDEO POST",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 4.dp, top = 0.dp, start = 20.dp, end = 20.dp),
            color = Color(0xFF8E8E93)
        )

        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(6.dp))
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 11.dp)
        ) {

            BasicTextField(
                value = title.value,
                onValueChange = { title.value = it },
                textStyle = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(42.dp))


        Text(
            text = "Edit Content of your Video post",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 4.dp, top = 0.dp, start = 20.dp, end = 20.dp),
            color = Color(0xFF8E8E93)
        )

        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(6.dp))
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 11.dp)
        ) {

            BasicTextField(
                value = description.value,
                onValueChange = { description.value = it },
                textStyle = MaterialTheme.typography.displaySmall.copy(color = Primary),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 47.dp)
            )
        }
    }
}
