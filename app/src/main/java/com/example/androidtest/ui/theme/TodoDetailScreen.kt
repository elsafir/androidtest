package com.example.androidtest.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidtest.ViewModel


@SuppressLint("RememberReturnType")
@Composable
fun TodoDetailScreen(id: Int, viewModel: ViewModel = viewModel()) {
    remember { viewModel.fetchTodoDetail(id) }
    val todo by viewModel.selectedTodo.collectAsState()

    todo?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = it.title, style = MaterialTheme.typography.bodyLarge)
            Text(text = if (it.completed) "Completed" else "Pending")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "User ID: ${it.userId}")
        }
    }
}
