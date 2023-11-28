package com.abhishek.todoapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val body: String? = null,
    val startTime: String,
    val endTime: String
)
