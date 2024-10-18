package edu.iesam.dam2024.app.data.API

import edu.iesam.dam2024.features.superHero.data.remote.SuperHeroService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://akabab.github.io/superhero-api/api/"

    fun providerRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun providerSuperHeroService(): SuperHeroService {
        return providerRetrofit().create(SuperHeroService::class.java)
    }

}