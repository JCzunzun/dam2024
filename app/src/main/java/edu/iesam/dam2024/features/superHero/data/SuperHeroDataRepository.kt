package edu.iesam.dam2024.features.superHero.data

import edu.iesam.dam2024.features.superHero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superHero.data.remote.SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superHero.domain.SuperHero
import edu.iesam.dam2024.features.superHero.domain.SuperHeroRepository

class SuperHeroDataRepository(
    private val local: SuperHeroXmlLocalDataSource,
    private val mockRemoteDataSource: SuperHeroMockRemoteDataSource
) :
    SuperHeroRepository {
    override fun getSuperHeros(): List<SuperHero> {
        val superHerosFromLocal = local.findAll()
        if (superHerosFromLocal.isEmpty()) {
            val superHerosFromRemote = mockRemoteDataSource.getSupersHeros()
            local.saveAll(superHerosFromRemote)
            return superHerosFromRemote
        } else {
            return superHerosFromLocal
        }
    }

    override fun getSuperHero(superHeroId: String): SuperHero? {
        val localSuperHero = local.findById(superHeroId)
        if (localSuperHero == null) {
            mockRemoteDataSource.getSuperHero(superHeroId)?.let {
                local.save(it)
                return it
            }
        }
        return localSuperHero
    }

}