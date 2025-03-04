package com.example.hardcat_task.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hardcat_task.data.Task
import com.example.hardcat_task.data.TaskViewModel

/*Function that represents the start screen TaskScreen*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(taskViewModel: TaskViewModel = viewModel(), onNavToAddTask:() -> Unit) {

    Scaffold(
        topBar = { TopAppBar(
            title = {Text("To Do List")},
            actions = {
                IconButton(onClick = onNavToAddTask) {
                    Text("+", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.onPrimary)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = Color.White
            )
        ) }
    ) {
        paddingValues ->  Column(modifier = Modifier.padding(paddingValues)) {
            TaskList(taskViewModel)
        }
    }
}

/*Function that displays a list of tasks*/
@Composable
fun TaskList(taskViewModel: TaskViewModel) {
    LazyColumn {
        items(taskViewModel.tasks) { task ->
            TaskItem(task, onChangeTaskState = { taskViewModel.changeCompletion(task) })
        }
    }
}

/*Function that defines one single task item on the list*/
@Composable
fun TaskItem(task: Task, onChangeTaskState: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = task.isCompleted, onCheckedChange = { onChangeTaskState() })
            Spacer(modifier = Modifier.width(8.dp))
            Text(task.description)
        }
        HorizontalDivider()
    }
}