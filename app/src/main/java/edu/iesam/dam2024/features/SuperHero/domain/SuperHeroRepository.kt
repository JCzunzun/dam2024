package edu.iesam.dam2024.features.SuperHero.domain

interface SuperHeroRepository {
    fun getSuperHeros(): List<SuperHero>
    fun getSuperHero(superHeroId: String): SuperHero?
}