package com.example.callingapi.api

import com.example.callingapi.model.Post
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {
    @GET("/posts")
    fun getAllPosts():Call<List<Post>>

    @GET("posts/{id}")
    fun getIndevidualPost(@Path("id") id: Int): Call<Post>
}