package edu.iesam.dam2024.features.movies.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.app.loadUrl
import edu.iesam.dam2024.databinding.ItemMovieBinding
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val itemMovie = ItemMovieBinding.bind(view)

    fun bind(movie: Movie, onClick : (movieId:String) -> Unit){
        itemMovie.apply {
            movieIdItem.text = movie.id
            movieImageItem.loadUrl(movie.poster)
            movieNameItem.text = movie.title
            view.setOnClickListener{
                onClick(movie.id)
            }
        }
    }
}