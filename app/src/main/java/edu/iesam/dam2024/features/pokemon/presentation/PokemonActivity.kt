package edu.iesam.dam2024.features.pokemon.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.iesam.dam2024.features.pokemon.domain.Pokemon
import edu.iesam.dam2024.features.pokemon.presentation.adapter.PokemonAdapter

class PokemonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemons)

    }
}