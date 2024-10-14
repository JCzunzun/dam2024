package edu.iesam.dam2024.features.pokemon.data

import edu.iesam.dam2024.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.iesam.dam2024.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.iesam.dam2024.features.pokemon.domain.Pokemon
import edu.iesam.dam2024.features.pokemon.domain.PokemonRepository

class PokemonDataRepository (
    private val local:PokemonXmlLocalDataSource,
    private val mockRemoteDataSource: PokemonMockRemoteDataSource
):
PokemonRepository{
    override fun getPokemons(): List<Pokemon> {
        val pokemonsFromLocal = local.findAll()
        if(pokemonsFromLocal.isEmpty()){
            val pokemonFromRemote = mockRemoteDataSource.getPokemons()
            local.saveAll(pokemonFromRemote)
            return  pokemonFromRemote
        }
        else{
            return pokemonsFromLocal
        }
    }

    override fun getPokemon(pokemonId:String): Pokemon? {
        val localPokemon = local.findById(pokemonId)
        if(localPokemon == null){
            mockRemoteDataSource.getPokemon(pokemonId)?.let {
                local.save(it)
                return it
            }
        }
        return localPokemon
    }
}