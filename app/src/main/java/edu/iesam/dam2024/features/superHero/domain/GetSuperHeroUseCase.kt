package edu.iesam.dam2024.features.superHero.domain

class GetSuperHeroUseCase(private val superHeroRepository: SuperHeroRepository) {

    operator suspend fun invoke(superHeroId: String): SuperHero? {
        return superHeroRepository.getSuperHero(superHeroId)
    }


}