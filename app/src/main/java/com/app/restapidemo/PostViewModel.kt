import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.app.restapidemo.AppDatabase
import com.app.restapidemo.Model.Post
import com.app.restapidemo.rertofit.RetrofitInstance
import kotlinx.coroutines.launch

class PostViewModel(application: Application) : AndroidViewModel(application) {

    private val postDao = AppDatabase.getDatabase(application).postDao()
    private val postsLiveData: LiveData<List<Post>> = postDao.getAllPosts() // Observe the local database

    // Method to fetch posts from API and insert into Room
    fun fetchPosts() {
        viewModelScope.launch {
            try {
                // Fetch posts from API
                val postsFromApi = RetrofitInstance.apiService.getPosts()

                // Insert posts into Room Database
                postDao.insertAll(postsFromApi)
            } catch (e: Exception) {
                // Handle errors
            }
        }
    }

    // Method to access live data for UI
    fun getPosts(): LiveData<List<Post>> {
        return postsLiveData
    }
}
