package edu.iesam.dam2024.features.superHero.data

import edu.iesam.dam2024.features.superHero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superHero.data.remote.SuperHeroApiRemoteDataSource
import edu.iesam.dam2024.features.superHero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superHero.domain.SuperHero
import edu.iesam.dam2024.features.superHero.domain.SuperHeroRepository

class SuperHeroDataRepository(
    private val local: SuperHeroXmlLocalDataSource,
    private val remoteDataSource: SuperHeroApiRemoteDataSource,
) :
    SuperHeroRepository {
    override suspend fun getSuperHeros(): List<SuperHero> {
        return remoteDataSource.getSuperHeros()
    }

    override suspend fun getSuperHero(superHeroId: String): SuperHero? {
        return remoteDataSource.getSuperHero(superHeroId)
    }

}