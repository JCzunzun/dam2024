package edu.iesam.dam2024.features.superHero.domain

interface SuperHeroRepository {
    suspend fun getSuperHeros(): List<SuperHero>
    suspend fun getSuperHero(superHeroId: String): SuperHero?
}