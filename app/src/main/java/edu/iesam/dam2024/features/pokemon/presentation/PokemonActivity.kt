package edu.iesam.dam2024.features.pokemon.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.R
import edu.iesam.dam2024.databinding.ActivityPokemonsBinding
import edu.iesam.dam2024.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.iesam.dam2024.features.pokemon.domain.Pokemon
import edu.iesam.dam2024.features.pokemon.presentation.adapter.PokemonAdapter

class PokemonActivity : AppCompatActivity() {
    private var _mainBinding : ActivityPokemonsBinding? = null
    private val mainBinding get () = _mainBinding!!

    private  val adapter= PokemonAdapter ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemons)
        setupView()

    }
    private fun setupView() {
        mainBinding.apply {
            navHostItemPokemon.apply {
                layoutManager = GridLayoutManager(
                    context,
                    1,
                    LinearLayoutManager.VERTICAL,
                    false
                )
                navHostItemPokemon.adapter = adapter
                adapter = this@PokemonActivity.adapter
            }
        }
    }
}