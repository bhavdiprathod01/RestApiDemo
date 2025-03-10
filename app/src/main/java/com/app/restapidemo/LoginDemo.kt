package com.app.restapidemo

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.restapidemo.Model.User
import com.app.restapidemo.rertofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = User(name = "John Doe", email = "johndoe@example.com")
        RetrofitInstance.apiService1.createUser(user).enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    // Handle the successful response
                    val createdUser = response.body()
                    Log.d("Success", "User created: $createdUser")
                } else {
                    // Handle unsuccessful response
                    Log.d("Error", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                // Handle failure
                Log.d("Failure", "Request failed: ${t.message}")
            }
        })
    }
}