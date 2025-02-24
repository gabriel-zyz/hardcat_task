package com.example.hardcat_task

data class Task(
    val id: Int,
    val description: String,
    var isCompleted: Boolean = false
)
