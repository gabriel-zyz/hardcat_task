package com.example.hardcat_task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hardcat_task.data.TaskViewModel
import com.example.hardcat_task.screens.AddTaskScreen
import com.example.hardcat_task.screens.TaskScreen

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


/*Function that sets up navigation for the app*/
@Composable
fun ToDoList(navController: NavHostController, taskViewModel: TaskViewModel = viewModel()) {
    //Define the navigation host that handles navigation and sets taskScreen as start screen
    NavHost(navController, startDestination = "taskScreen") {
        composable("taskScreen") {
            TaskScreen(
                taskViewModel = taskViewModel,
                onNavToAddTask = { navController.navigate("addTaskScreen") }
            )
        }
        composable("addTaskScreen") {
            AddTaskScreen(
                navController = navController,
                taskViewModel = taskViewModel
            )
        }
    }
}
