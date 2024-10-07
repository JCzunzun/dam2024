package edu.iesam.dam2024.features.superHero.presentation

import android.content.Context
import edu.iesam.dam2024.features.superHero.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.superHero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superHero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superHero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superHero.domain.GetSuperHerosUseCase

class SuperHeroFactory(context: Context) {
    private val superHeroMockRemoteDataSource = SuperHeroMockRemoteDataSource()
    private val superHeroLocal = SuperHeroXmlLocalDataSource(context)
    private val superHeroDataRepository =
        SuperHeroDataRepository(superHeroLocal, superHeroMockRemoteDataSource)
    private val getSuperHerosUseCase = GetSuperHerosUseCase(superHeroDataRepository)
    private val getSuperHeroUseCase = GetSuperHeroUseCase(superHeroDataRepository)

    fun buildViewModel(): SuperHeroViewModel {
        return SuperHeroViewModel(
            getSuperHerosUseCase
        )
    }

    fun buildSuperHeroDetailViewMovie(): SuperHeroDetailViewModel {
        return SuperHeroDetailViewModel(getSuperHeroUseCase)
    }
}