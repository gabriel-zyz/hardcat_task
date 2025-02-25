## To Do List App (Jetpack Compose)

A simple To-Do List app built with Jetpack Compose(Kotlin). Users can use this app to add tasks, mark as completed, and view tasks in a list.


### Project Structure
- #### MainActivity.kt: App entry point, set up navigation
- #### screens
  - **TaskScreen.kt**: Main screen which displays task list
  - **AddTaskScreen.kt**: Screen for task adding
- #### data
  - **Task**: Data model for tasks
  - **TaskViewModel**: Manages tasks and state


### How to Run the Project
1. Clone the Github repo: https://github.com/gabriel-zyz/Hardcat_Task_MAUI.git
2. Open the project in Android Studio
3. Run the app in emulator(I used Pixel 4 - API 34 for testing)


### How to Use the App
- View added tasks in the list on the main screen
- Mark added tasks completed in the check boxes on the list
- To visit the task-adding screen, click "+" button on topbar of main screen
- Add new tasks on task-adding screen(the description can not be empty)
