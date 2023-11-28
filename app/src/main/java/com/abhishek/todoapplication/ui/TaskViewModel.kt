package com.abhishek.todoapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhishek.todoapplication.data.Task
import com.abhishek.todoapplication.data.TaskDao
import com.abhishek.todoapplication.data.TaskEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TaskViewModel(
    private val dao: TaskDao
): ViewModel() {

    private val _state = MutableStateFlow(TaskState())

    val state: MutableStateFlow<TaskState> = _state

    fun onEvent(event: TaskEvent) {
        when(event) {
            is TaskEvent.DeleteTask -> {
                viewModelScope.launch {
                    dao.deleteTask(event.task)
                }
            }
            is TaskEvent.SetEndTime -> {
                _state.update {
                    it.copy(
                        endTime = event.endTime
                    )
                }
            }


            TaskEvent.HideDialog -> {
                _state.update {
                    it.copy(
                        isAddingTask = false
                    )
                }
            }
            TaskEvent.SaveTask -> {
                val title = state.value.title
                val body = state.value.body
                val startTime = state.value.startTime
                val endTime = state.value.endTime

                if(title.isBlank()) {
                    return
                }
                val task = Task(
                    title = title,
                    body = body,
                    startTime = startTime,
                    endTime = endTime
                )

                viewModelScope.launch {
                    dao.insertTask(task)
                }
                _state.update {
                    it.copy(
                        isAddingTask = false,
                        title = "",
                        body = "",
                        startTime = "00:00",
                        endTime = "00:00"
                    )
                }
            }
            is TaskEvent.SetBody -> {
                _state.update {
                    it.copy(
                        body = event.body
                    )
                }
            }
            is TaskEvent.SetTitle -> {
                _state.update {
                    it.copy(
                        title = event.title
                    )
                }
            }
            TaskEvent.ShowDialog -> {
                _state.update {
                    it.copy(
                        isAddingTask = true
                    )
                }
            }
            is TaskEvent.SetStartTime -> {
                _state.update {
                    it.copy(
                        startTime = event.startTime
                    )
                }
            }
        }
    }
}