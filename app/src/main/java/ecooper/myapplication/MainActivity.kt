package ecooper.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    private var movies : MutableList<Movie> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val moviesRV = findViewById<RecyclerView>(R.id.moviesRV)
        var adapter: MovieAdapter

        val client = AsyncHttpClient()
        client[
                "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed",
                object: JsonHttpResponseHandler()
                {
                    override fun onFailure(
                        statusCode: Int,
                        headers: Headers?,
                        response: String?,
                        throwable: Throwable?
                    ) {
                        Toast.makeText(this@MainActivity, "Failed to retrieve movies", Toast.LENGTH_SHORT).show()
                    }

                    override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON?) {
                        val gson = Gson()
                        val arrayMovieType = object : TypeToken<List<Movie>>() {}.type
                        val moviesJSON = json?.jsonObject?.get("results").toString()
                        movies = gson.fromJson(moviesJSON, arrayMovieType)

                        adapter = MovieAdapter(movies)

                        moviesRV.adapter = adapter
                        moviesRV.layoutManager = LinearLayoutManager(this@MainActivity)
                    }

                }
        ]
    }
}