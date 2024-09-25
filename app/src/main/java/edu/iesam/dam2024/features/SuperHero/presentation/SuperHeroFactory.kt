package edu.iesam.dam2024.features.SuperHero.presentation

import edu.iesam.dam2024.features.SuperHero.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.SuperHero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.SuperHero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.SuperHero.domain.GetSuperHerosUseCase

class SuperHeroFactory {
    fun buildViewModel(): SuperHeroViewModel {
        return SuperHeroViewModel(
            GetSuperHerosUseCase(SuperHeroDataRepository(SuperHeroMockRemoteDataSource())),
            GetSuperHeroUseCase(SuperHeroDataRepository(SuperHeroMockRemoteDataSource()))
        )
    }
}