package edu.iesam.dam2024.features.movies.presentation.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.movies.presentation.MovieDiffUtil

class MovieAdapter : ListAdapter<Movie, MovieViewHolder>(MovieDiffUtil()){

    lateinit var onClick : (movieId : String) -> Unit

    fun setEvent(onClick: (movieId: String) -> Unit){
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(currentList[position],onClick)
    }


}