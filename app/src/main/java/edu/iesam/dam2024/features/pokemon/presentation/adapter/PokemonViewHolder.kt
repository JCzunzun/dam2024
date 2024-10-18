package edu.iesam.dam2024.features.pokemon.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.app.loadUrl
import edu.iesam.dam2024.databinding.ItemPokemonsBinding
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val itemPokemon = ItemPokemonsBinding.bind(view)


    fun bind(pokemon: Pokemon, onClick: (pokemonid: String) -> Unit) {
        itemPokemon.apply {
            pokemon.image?.let {
                pokemonImageItem.loadUrl(it)
            }
            pokemonNameItem.text = pokemon.name
            view.setOnClickListener {
                onClick(pokemon.id)
            }
        }
    }

}