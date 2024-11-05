package edu.iesam.dam2024.features.movies.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.dam2024.features.movies.domain.Movie


class MovieDiffUtil: DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }


}