package edu.iesam.dam2024.features.SuperHero.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R

class SuperHeroActivity : AppCompatActivity() {
    private val superHeroFactory: SuperHeroFactory = SuperHeroFactory()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = superHeroFactory.buildViewModel()
        val superHero = viewModel.viewCreated()
        Log.d("@dev", superHero.toString())
    }

}