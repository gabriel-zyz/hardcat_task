package com.example.hardcat_task

import android.app.ActivityManager.TaskDescription
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {
    private var counter = 0
    var tasks = mutableStateListOf<Task>()

    fun addTask(description: String) {
        if (description.isNotBlank()) {
            tasks.add(Task(counter++, description))
        }
    }

    fun changeCompletion(task: Task) {
        val index = tasks.indexOf(task)
        if (index != -1) {
            tasks[index] = tasks[index].copy(isCompleted = !tasks[index].isCompleted)
        }
    }

}