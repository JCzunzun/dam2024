package edu.iesam.dam2024.features.superHero.di

import edu.iesam.dam2024.features.superHero.data.remote.SuperHeroService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class SuperHeroModule {
    @Single
    fun provideSuperHeroService(retrofit: Retrofit) = retrofit.create(SuperHeroService::class.java)
}