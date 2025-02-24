package com.example.hardcat_task

/*Data class that defines the fields of task*/
data class Task(
    val id: Int,
    val description: String,
    var isCompleted: Boolean = false
)
