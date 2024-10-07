package edu.iesam.dam2024.features.superHero.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superHero.data.local.SuperHeroXmlLocalDataSource

class SuperHeroActivity : AppCompatActivity {
    private lateinit var xmlLocalDataSource: SuperHeroXmlLocalDataSource
    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        xmlLocalDataSource = SuperHeroXmlLocalDataSource(this)
        superHeroFactory= SuperHeroFactory(this)
        viewModel = superHeroFactory.buildViewModel()

    }

}