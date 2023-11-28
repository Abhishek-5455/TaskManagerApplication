package com.abhishek.todoapplication.ui

import com.abhishek.todoapplication.data.Task

data class TaskState(
    val taskList: List<Task> = emptyList(),
    val title: String = "",
    val body: String = "",
    val startTime: String = "00:00",
    val endTime: String = "00:00",
    val isAddingTask: Boolean = false
)
