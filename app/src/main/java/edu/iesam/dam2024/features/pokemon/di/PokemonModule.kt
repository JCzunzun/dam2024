package edu.iesam.dam2024.features.pokemon.di

import edu.iesam.dam2024.features.pokemon.data.remote.PokemonService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class PokemonModule {
    @Single
    fun providePokemonService(retrofit: Retrofit) = retrofit.create(PokemonService::class.java)

}