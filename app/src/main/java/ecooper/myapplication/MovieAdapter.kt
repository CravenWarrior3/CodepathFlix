package ecooper.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var moviePoster: ImageView
        var movieTitle: TextView
        var movieDescription: TextView

        init {
            moviePoster = itemView.findViewById(R.id.moviePoster)
            movieTitle = itemView.findViewById(R.id.movieTitle)
            movieDescription = itemView.findViewById(R.id.movieDescription)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val newView = inflater.inflate(R.layout.movie_item, parent, false)
        return ViewHolder(newView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.movieTitle.text = movie.title
        holder.movieDescription.text = movie.description

        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500/" + movie.posterURL)
            .centerInside()
            .into(holder.moviePoster)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}