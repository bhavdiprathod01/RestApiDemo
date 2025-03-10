package com.app.restapidemo
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.restapidemo.Model.Post

@Dao
interface PostDao {

    // Insert a list of posts
    @Insert
    suspend fun insertAll(posts: List<Post>)

    // Get all posts
    @Query("SELECT * FROM posts")
    suspend fun getAllPosts(): List<Post>
}