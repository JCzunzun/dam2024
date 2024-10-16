package edu.iesam.dam2024.features.pokemon.presentation

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonDiffUtil : DiffUtil.ItemCallback<Pokemon>() {
    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }
}