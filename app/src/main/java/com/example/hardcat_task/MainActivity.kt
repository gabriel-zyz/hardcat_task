package com.example.hardcat_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.hardcat_task.ui.theme.Hardcat_TaskTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            ToDoList(navController)
        }
    }
}

@Composable
fun ToDoList(navController: NavHostController, taskViewModel: TaskViewModel = viewModel()) {
    NavHost(navController, startDestination = "taskList") {
        composable("taskList") {
            TaskScreen(
                taskViewModel = taskViewModel,
                onNavToAddTask = { navController.navigate("addTask") }
            )
        }
        composable("addTask") {
            AddTaskScreen(
                navController = navController,
                taskViewModel = taskViewModel
            )
        }
    }
}
