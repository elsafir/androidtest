package com.example.androidtest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {
    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos: StateFlow<List<Todo>> = _todos

    private val _selectedTodo = MutableStateFlow<Todo?>(null)
    val selectedTodo: StateFlow<Todo?> = _selectedTodo

    init {
        fetchTodos()
    }

    private fun fetchTodos() {
        viewModelScope.launch {
            _todos.value = TodoRepository.getTodos()
        }
    }

    fun fetchTodoDetail(id: Int) {
        viewModelScope.launch {
            _selectedTodo.value = TodoRepository.getTodoDetail(id)
        }
    }
}