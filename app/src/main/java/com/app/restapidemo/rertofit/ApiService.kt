package com.app.restapidemo.rertofit
import com.app.restapidemo.Model.Post
import com.app.restapidemo.Model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
    @POST("users/create")
    fun createUser(@Body user: User): Call<User>
}