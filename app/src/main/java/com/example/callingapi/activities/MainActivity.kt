package com.example.callingapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.crashlytics.android.Crashlytics
import com.example.callingapi.R
import com.example.callingapi.api.PostApi
import com.example.callingapi.api.RestAdapter
import com.example.callingapi.model.Post
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_selected_id.*
import kotlinx.android.synthetic.main.data_retrofit.*
import kotlinx.android.synthetic.main.data_retrofit.txtTitle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private val retrofitAdapter: RetrofitAdapter by lazy { RetrofitAdapter(this::onClickItem) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_main)
        rvRetrofit.layoutManager = LinearLayoutManager(this)
        rvRetrofit.adapter = retrofitAdapter
        loadPosts()
    }

    private fun onClickItem(post: Post) {
        val apiSingleCalls = RestAdapter.getClient().create(PostApi::class.java)
        val postCall = apiSingleCalls.getIndevidualPost(post.id!!)
        postCall.enqueue(object : Callback<Post> {

            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    val postId = response.body()
                    var userId = postId!!.userId.toString()
                    var post_id = postId.id.toString()
                    var title = postId.title.toString()
                    var body = postId.body.toString()
                    var intent = SelectedIdActivity.newActivity(
                        this@MainActivity,
                        userId = post.userId,
                        id = post.id,
                        title = post.title,
                        body = post.body

                    )
                    startActivity(intent)
                } else {
                    Toast.makeText(this@MainActivity, getString(R.string.unsuccessful), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("Error", "Network Error")
            }
        })

    }

    fun loadPosts() {
        val apiCalls = RestAdapter.getClient().create(PostApi::class.java)
        val postCall = apiCalls.getAllPosts()
        postCall.enqueue(object : Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response?.body() != null)
                    retrofitAdapter.setPostListItems(response.body()!!)

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("Error", "Network Error")
            }
        })
    }
}


