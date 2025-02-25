package com.example.hardcat_task.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

/*View model that manage the task data*/
class TaskViewModel: ViewModel() {
    private var counter = 0

    var tasks = mutableStateListOf(
        Task(counter++, "Task 1"),
        Task(counter++, "Task 2"),
        Task(counter++, "Task 3")
    )

    /*Function that handles the adding of task*/
    fun addTask(description: String) {
        if (description.isNotBlank()) {
            tasks.add(Task(counter++, description))
        }
    }

    /*Function that handles the changing of task completion status*/
    fun changeCompletion(task: Task) {
        val index = tasks.indexOf(task)
        if (index != -1) {
            tasks[index] = tasks[index].copy(isCompleted = !tasks[index].isCompleted)
        }
    }
}