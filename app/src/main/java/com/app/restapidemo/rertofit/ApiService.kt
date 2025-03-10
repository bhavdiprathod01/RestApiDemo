package com.app.restapidemo.rertofit
import com.app.restapidemo.Model.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}