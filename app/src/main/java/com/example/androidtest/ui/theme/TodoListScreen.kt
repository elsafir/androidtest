package com.example.androidtest.ui.theme



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androidtest.Todo
import com.example.androidtest.ViewModel


@Composable
fun TodoListScreen(navController: NavController, viewModel: ViewModel = viewModel()) {
    val todos by viewModel.todos.collectAsState()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(todos) { todo ->
            TodoItem(todo) {
                navController.navigate("detail/${todo.id}")
            }
        }
    }
}

@Composable
fun TodoItem(todo: Todo, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = todo.title, style = MaterialTheme.typography.bodyLarge)
            Text(text = if (todo.completed) "Completed" else "Pending")
        }
    }
}

