package com.relatablecode.retrofitdemoapplication

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("todos")
    suspend fun getTodos(): List<Todo>

    @POST("posts")
    suspend fun addPost(@Body newPost: Post): Post

    @PUT("posts/{id}")
    suspend fun updatePost(@Path("id") id: Int, @Body postUpdate: Post): Post

    @DELETE("posts/{id}")
    suspend fun deletePost(@Path("id") id: Int): Response<Unit>

}
