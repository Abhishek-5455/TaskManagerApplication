package com.abhishek.todoapplication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abhishek.todoapplication.data.TaskEvent
import com.abhishek.todoapplication.ui.components.AddTaskDialog
import com.abhishek.todoapplication.ui.components.TaskComponent
import com.abhishek.todoapplication.ui.components.WelcomeMessage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskMainScreen(
    state: TaskState,
    onEvent: (TaskEvent) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Task"
                )
            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onEvent(TaskEvent.ShowDialog)
            }) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add Task"
                )
            }
        }
    ) {paddingValues ->
        if(state.isAddingTask) {
            AddTaskDialog(
                state = state,
                onEvent = onEvent
            )
        }
        LazyColumn(
            contentPadding = paddingValues,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            item {
                WelcomeMessage(
                    modifier = Modifier.fillMaxWidth(),
                    userName = "Abhishek",
                    list = state.taskList
                )
            }
            items(state.taskList) {task ->
                TaskComponent(
                    task = task,
                    onIconClick = { deleteTask ->
                        onEvent(TaskEvent.DeleteTask(deleteTask))
                    }
                )
            }
        }
    }
}

