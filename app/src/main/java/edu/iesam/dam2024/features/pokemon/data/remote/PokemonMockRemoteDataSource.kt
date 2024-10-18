package edu.iesam.dam2024.features.pokemon.data.remote

import edu.iesam.dam2024.features.pokemon.domain.Poderes
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonMockRemoteDataSource {
    companion object {
        val listaDePokemons = listOf(
            Pokemon(
                id = "1",
                image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png",
                name = "Pikachu",
                tipo = "Eléctrico",
                poderes = Poderes("Impactrueno", "Ataque Rápido", "Rayo", "Voltio Cruel")
            ),
            Pokemon(
                id = "2",
                image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
                name = "Charmander",
                tipo = "Fuego",
                poderes = Poderes("Lanzallamas", "Ascuas", "Garra Dragón", "Furia Dragón")
            ),
            Pokemon(
                id = "3",
                image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png",
                name = "Squirtle",
                tipo = "Agua",
                poderes = Poderes("Pistola Agua", "Hidro Bomba", "Rayo Hielo", "Surf")
            ),
            Pokemon(
                id = "4",
                image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
                name = "Bulbasaur",
                tipo = "Planta/Veneno",
                poderes = Poderes("Latigazo", "Hoja Afilada", "Rayo Solar", "Bomba Lodo")
            ),
            Pokemon(
                id = "5",
                image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/039.png",
                name = "Jigglypuff",
                tipo = "Normal/Hada",
                poderes = Poderes("Canto", "Desenrollar", "Rayo Solar", "Carantoña")
            ),
            Pokemon(
                id = "6",
                image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/094.png",
                name = "Gengar",
                tipo = "Fantasma/Veneno",
                poderes = Poderes("Bola Sombra", "Puño Fuego", "Hipnosis", "Psíquico")
            ),
            Pokemon(
                id = "7",
                image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/133.png",
                name = "Eevee",
                tipo = "Normal",
                poderes = Poderes("Ataque Rápido", "Mordisco", "Refugio", "Doble Filo")
            ),
            Pokemon(
                id = "8",
                image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/131.png",
                name = "Lapras",
                tipo = "Agua/Hielo",
                poderes = Poderes("Surf", "Canto Helado", "Ventisca", "Hidropulso")
            ),
            Pokemon(
                id = "9",
                image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/143.png",
                name = "Snorlax",
                tipo = "Normal",
                poderes = Poderes("Golpe Cuerpo", "Descanso", "Terremoto", "Pisotón")
            ),
            Pokemon(
                id = "10",
                image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/149.png",
                name = "Dragonite",
                tipo = "Dragón/Volador",
                poderes = Poderes("Hiperrayo", "Vuelo", "Puño Trueno", "Llamarada")
            ),
            Pokemon(
                id = "11",
                image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/150.png",
                name = "Mewtwo",
                tipo = "Psíquico",
                poderes = Poderes("Confusión", "Psíquico", "Rayo Hielo", "A Bocajarro")
            ),
            Pokemon(
                id = "12",
                image = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/068.png",
                name = "Machamp",
                tipo = "Lucha",
                poderes = Poderes("Golpe Karate", "Tajo Cruzado", "Avalancha", "Dinamopalm")
            )
        )
    }

    fun getPokemons(): List<Pokemon> {
        return listaDePokemons
    }

    fun getPokemon(pokemonId: String): Pokemon? {
        return listaDePokemons.firstOrNull { pokemon ->
            pokemon.id == pokemonId
        }
        }
    }
