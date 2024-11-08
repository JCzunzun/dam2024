package edu.iesam.dam2024.features.pokemon.domain

import org.koin.core.annotation.Single

@Single
class GetPokemonUseCase (private val pokemonRepository: PokemonRepository) {
    operator fun invoke(pokemonId:String):Pokemon?{
        return pokemonRepository.getPokemon(pokemonId)
    }
}