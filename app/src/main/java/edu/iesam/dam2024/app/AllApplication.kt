package edu.iesam.dam2024.app

import android.app.Application
import edu.iesam.dam2024.app.di.AppModule
import edu.iesam.dam2024.app.di.RemoteModule
import edu.iesam.dam2024.features.movies.di.MovieModule
import edu.iesam.dam2024.features.pokemon.di.PokemonModule
import edu.iesam.dam2024.features.superHero.di.SuperHeroModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.module

class AllApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AllApplication)
            modules(AppModule().module,
                RemoteModule().module,
                PokemonModule().module,
                MovieModule().module,
                SuperHeroModule().module)
        }
    }
}