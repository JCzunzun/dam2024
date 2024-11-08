package edu.iesam.dam2024.features.superHero.domain

import org.koin.core.annotation.Single

@Single
class GetSuperHerosUseCase(private val superHeroRepository: SuperHeroRepository) {
    operator suspend fun invoke(): List<SuperHero> {
        return superHeroRepository.getSuperHeros()
    }
}