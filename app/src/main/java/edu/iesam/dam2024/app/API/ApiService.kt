package edu.iesam.dam2024.app.API

import edu.iesam.dam2024.features.pokemon.domain.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call


interface ApiService {


    @GET("pokemon")
    fun getAllPokemons(): Call<List<Pokemon>>


    @GET("pokemon/{name}")
    fun getPokemonById(@Path("name") name: String): Call<Pokemon>
}