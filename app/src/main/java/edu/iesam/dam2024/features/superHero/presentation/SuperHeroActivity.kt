package edu.iesam.dam2024.features.superHero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superHero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superHero.domain.SuperHero


class SuperHeroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)

    }

}