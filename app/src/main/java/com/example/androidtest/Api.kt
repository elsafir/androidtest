package com.example.androidtest

import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("todos")
    suspend fun getTodos(): List<Todo>

    @GET("todos/{id}")
    suspend fun getTodoDetail(@Path("id") id: Int): Todo
}

data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)
