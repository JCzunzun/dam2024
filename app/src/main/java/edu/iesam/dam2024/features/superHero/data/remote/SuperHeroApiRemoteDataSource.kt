package edu.iesam.dam2024.features.superHero.data.remote

import edu.iesam.dam2024.features.superHero.domain.SuperHero

class SuperHeroApiRemoteDataSource(private val superHeroService: SuperHeroService) {

    suspend fun getSuperHeros(): List<SuperHero> {
        val response = superHeroService.requestSuperHeros()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            return emptyList()
        }
    }

    suspend fun getSuperHero(id: String): SuperHero? {
        val response = superHeroService.requestSuperHero(id)
        if (response.isSuccessful) {
            return response.body()
        } else {
            return null
        }
    }
}