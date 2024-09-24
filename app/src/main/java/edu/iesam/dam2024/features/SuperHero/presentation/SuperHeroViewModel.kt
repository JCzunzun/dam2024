package edu.iesam.dam2024.features.SuperHero.presentation

import edu.iesam.dam2024.features.SuperHero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.SuperHero.domain.SuperHero

class SuperHeroViewModel(private val getSuperHeroUseCase: GetSuperHeroUseCase) {
    fun viewCreated(): List<SuperHero> {
        return getSuperHeroUseCase.invoke()
    }
}