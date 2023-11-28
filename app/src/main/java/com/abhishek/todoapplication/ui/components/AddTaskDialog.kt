package com.abhishek.todoapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abhishek.todoapplication.data.TaskEvent
import com.abhishek.todoapplication.ui.TaskState
import com.abhishek.todoapplication.ui.theme.Telex

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskDialog(
    state: TaskState,
    onEvent: (TaskEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = { onEvent(TaskEvent.HideDialog) },
        confirmButton = {
            Button(onClick = {
                onEvent(TaskEvent.SaveTask)
                onEvent(TaskEvent.HideDialog)
            }) {
                Text(
                    text = "ADD",
                    fontFamily = Telex
                )
            }
        },
        shape = RoundedCornerShape(12.dp),
        title = {
            Text(
                text = "Add Task"
            )
        },
        text = {
            Column(
                modifier = Modifier.padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = state.title,
                    onValueChange = {
                        onEvent(TaskEvent.SetTitle(it))
                    },
                    label = {
                        Text(
                            text = "Title",
                            fontFamily = Telex
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = state.body,
                    onValueChange = {
                        onEvent(
                            TaskEvent.SetBody(it)
                        )
                    },
                    label = {
                        Text(
                            text = "Description",
                            fontFamily = Telex
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = state.startTime,
                        onValueChange = {
                            onEvent(TaskEvent.SetStartTime(it))
                        },
                        label = {
                            Text(
                                text = "Start Time",
                                fontFamily = Telex
                            )
                        },
                        modifier = Modifier.weight(0.5f)
                    )
                    OutlinedTextField(
                        value = state.endTime,
                        onValueChange = {
                            onEvent(TaskEvent.SetEndTime(it))
                        },
                        label = {
                            Text(
                                text = "End Time",
                                fontFamily = Telex
                            )
                        },
                        modifier = Modifier.weight(0.5f)
                    )
                }
            }
        }
    )
}