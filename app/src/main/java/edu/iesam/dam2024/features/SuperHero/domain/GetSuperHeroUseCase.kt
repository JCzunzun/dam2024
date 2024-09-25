package edu.iesam.dam2024.features.SuperHero.domain

class GetSuperHeroUseCase(private val superHeroRepository: SuperHeroRepository) {

    operator fun invoke(superHeroId: String): SuperHero? {
        return superHeroRepository.getSuperHero(superHeroId)
    }


}