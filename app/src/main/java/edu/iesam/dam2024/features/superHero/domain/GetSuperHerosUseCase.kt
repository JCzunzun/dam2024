package edu.iesam.dam2024.features.superHero.domain

class GetSuperHerosUseCase(private val superHeroRepository: SuperHeroRepository) {
    operator fun invoke(): List<SuperHero> {
        return superHeroRepository.getSuperHeros()
    }
}