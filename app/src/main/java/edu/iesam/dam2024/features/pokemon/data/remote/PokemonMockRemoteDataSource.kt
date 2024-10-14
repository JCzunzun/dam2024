package edu.iesam.dam2024.features.pokemon.data.remote

import edu.iesam.dam2024.features.pokemon.domain.Poderes
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonMockRemoteDataSource {
    private val listaDePokemons = listOf(
        Pokemon(
            id = "1",
            image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png",
            name = "Pikachu",
            tipo = "Eléctrico",
            poderes = Poderes(
                poder1 = "Impactrueno",
                poder2 = "Ataque Rápido",
                poder3 = "Onda Trueno",
                poder4 = "Cola Férrea"
            )
        ),
        Pokemon(
            id = "2",
            image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
            name = "Bulbasaur",
            tipo = "Planta/Veneno",
            poderes = Poderes(
                poder1 = "Látigo Cepa",
                poder2 = "Rayo Solar",
                poder3 = "Drenadoras",
                poder4 = "Hoja Afilada"
            )
        ),
        Pokemon(
            id = "3",
            image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            name = "Charmander",
            tipo = "Fuego",
            poderes = Poderes(
                poder1 = "Lanzallamas",
                poder2 = "Ascuas",
                poder3 = "Garra Dragón",
                poder4 = "Infierno"
            )
        ),
        Pokemon(
            id = "4",
            image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png",
            name = "Squirtle",
            tipo = "Agua",
            poderes = Poderes(
                poder1 = "Pistola Agua",
                poder2 = "Hidrobomba",
                poder3 = "Caparazón Reflejo",
                poder4 = "Surf"
            )
        )
    )

    fun getPokemons():List<Pokemon>{
        return listaDePokemons
    }
    fun getPokemon(pokemonId:String):Pokemon?{
        return listaDePokemons.firstOrNull{pokemon ->
            pokemon.id == pokemonId
        }
    }
}