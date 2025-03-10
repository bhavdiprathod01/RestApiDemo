package com.app.restapidemo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.restapidemo.Model.Post
import com.app.restapidemo.rertofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    fun fetchPosts() {
        RetrofitInstance.apiService.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    _posts.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
