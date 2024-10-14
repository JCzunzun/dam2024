package edu.iesam.dam2024.features.pokemon.domain

class GetPokemonsUseCase(private val pokemonRepository: PokemonRepository) {
    operator fun invoke():List<Pokemon>{
        return pokemonRepository.getPokemons()
    }
}