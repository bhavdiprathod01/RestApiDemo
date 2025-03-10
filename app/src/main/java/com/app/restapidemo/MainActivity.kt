import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.restapidemo.Adapter.PostAdapter
import com.app.restapidemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val postViewModel: PostViewModel by viewModels()
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postAdapter = PostAdapter() // Assuming you have an adapter to display the posts
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }

        // Observe the data from Room (postViewModel.getPosts() is LiveData)
        postViewModel.getPosts().observe(this, { posts ->
            postAdapter.submitList(posts)
        })

        // Fetch data from API and store it in Room
        postViewModel.fetchPosts()
    }
}
