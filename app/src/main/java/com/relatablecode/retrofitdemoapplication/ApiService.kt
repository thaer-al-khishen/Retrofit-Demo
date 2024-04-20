package com.relatablecode.retrofitdemoapplication

import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    suspend fun getTodos(): List<Todo>
}
