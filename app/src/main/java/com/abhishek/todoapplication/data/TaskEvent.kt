package com.abhishek.todoapplication.data

sealed interface TaskEvent {
    object SaveTask: TaskEvent
    data class SetTitle(val title: String): TaskEvent
    data class SetBody(val body: String): TaskEvent
    data class SetStartTime(val startTime: String): TaskEvent
    data class SetEndTime(val endTime: String): TaskEvent

    object ShowDialog: TaskEvent
    object HideDialog: TaskEvent

    data class DeleteTask(val task: Task): TaskEvent
}