package com.example.androidtest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TodoRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(Api::class.java)

    suspend fun getTodos(): List<Todo> = apiService.getTodos()

    suspend fun getTodoDetail(id: Int): Todo = apiService.getTodoDetail(id)
}