package edu.iesam.dam2024.features.pokemon.domain

import org.koin.core.annotation.Single

@Single
class GetPokemonsUseCase(private val pokemonRepository: PokemonRepository) {
    operator fun invoke():List<Pokemon>{
        return pokemonRepository.getPokemons()
    }
}