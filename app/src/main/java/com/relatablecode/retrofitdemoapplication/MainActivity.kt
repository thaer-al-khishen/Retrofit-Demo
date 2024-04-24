package com.relatablecode.retrofitdemoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newTodo = Post(userId = 1, title = "Title", body = "Body", id = 1)

        CoroutineScope(Dispatchers.IO).launch {
            //GET
            val getTodos = RetrofitClient.apiService.getTodos()
            Log.d("GetTodos", getTodos.toString())

            // POST - Add new Post
            val addedPost = RetrofitClient.apiService.addPost(newTodo)
            Log.d("AddedPost", addedPost.toString())

            // Put - Update Post
            val updatedPost = RetrofitClient.apiService.updatePost(newTodo.id, newTodo)
            Log.d("UpdatedPost", updatedPost.toString())

            // DELETE - Delete Post
            val deleteResponse = RetrofitClient.apiService.deletePost(newTodo.id)
            if (deleteResponse.isSuccessful) {
                Log.d("DeletePost", "Post deleted successfully")
            } else {
                Log.d("DeletePost", "Failed to delete post")
            }
        }

    }

}
