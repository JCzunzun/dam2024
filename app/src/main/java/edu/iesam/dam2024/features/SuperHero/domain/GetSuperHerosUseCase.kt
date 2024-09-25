package edu.iesam.dam2024.features.SuperHero.domain

class GetSuperHerosUseCase(private val superHeroRepository: SuperHeroRepository) {
    operator fun invoke(): List<SuperHero> {
        return superHeroRepository.getSuperHeros()
    }
}