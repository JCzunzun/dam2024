package edu.iesam.dam2024.features.pokemon.presentation

import android.content.Context
import edu.iesam.dam2024.features.pokemon.data.PokemonDataRepository
import edu.iesam.dam2024.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.iesam.dam2024.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.iesam.dam2024.features.pokemon.domain.GetPokemonUseCase
import edu.iesam.dam2024.features.pokemon.domain.GetPokemonsUseCase

class PokemonFactory(private val context: Context) {

    private val pokemonMockRemoteDataSource = PokemonMockRemoteDataSource()
    private val pokemonLocal= PokemonXmlLocalDataSource(context)
    private val pokemonDataRepository = PokemonDataRepository(pokemonLocal, pokemonMockRemoteDataSource)
    private val getPokemonsUseCase= GetPokemonsUseCase(pokemonDataRepository)
    private val getPokemonUseCase = GetPokemonUseCase(pokemonDataRepository)

    fun buildListPokemonViewModel():PokemonViewModel{
        return PokemonViewModel(getPokemonsUseCase)
    }

    fun builPokemonDetailViewModel():PokemonDetailViewModel{
        return PokemonDetailViewModel(getPokemonUseCase)
    }
}