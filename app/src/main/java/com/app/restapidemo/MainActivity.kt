package com.app.restapidemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.restapidemo.Adapter.PostAdapter

class MainActivity : AppCompatActivity() {
    private val postViewModel: PostViewModel by viewModels()
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        postAdapter = PostAdapter()
        recyclerView.adapter = postAdapter

        postViewModel.posts.observe(this, Observer { posts ->
            // Update UI when data changes
            postAdapter.submitList(posts)
        })

        // Fetch posts
        postViewModel.fetchPosts()
    }
}