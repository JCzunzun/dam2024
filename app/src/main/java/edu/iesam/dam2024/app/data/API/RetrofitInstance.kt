package edu.iesam.dam2024.app.data.API

import edu.iesam.dam2024.features.pokemon.data.remote.PokemonService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private const val BASE_URL = "https://pokeapi.co/api/v2"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: PokemonService by lazy {
        retrofit.create(PokemonService::class.java)
    }
}