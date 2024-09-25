package edu.iesam.dam2024.features.SuperHero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.SuperHero.domain.SuperHero

class SuperHeroActivity : AppCompatActivity() {
    private val superHeroFactory: SuperHeroFactory = SuperHeroFactory()
    private val viewModel = superHeroFactory.buildViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superHero = viewModel.viewCreated()
        bindDate(superHero)
        Log.d("@dev", superHero.toString())
    }

    private fun bindDate(superHeros: List<SuperHero>) {
        findViewById<TextView>(R.id.superhero_id_1).text = superHeros[0].id
        findViewById<TextView>(R.id.superhero_name_1).text = superHeros[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            val superHero1: SuperHero? = viewModel.itemSelected(superHeros[0].id)
            superHero1?.let {
                Log.d("@dev", "Super Heroe seleccionado: ${it.name}")
            }
        }

        findViewById<TextView>(R.id.superhero_id_2).text = superHeros[1].id
        findViewById<TextView>(R.id.superhero_name_2).text = superHeros[1].name
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            val superHero2: SuperHero? = viewModel.itemSelected(superHeros[1].id)
            superHero2?.let {
                Log.d("@dev", "Super Heroe seleccionado: ${it.name}")
            }
        }

        findViewById<TextView>(R.id.superhero_id_3).text = superHeros[2].id
        findViewById<TextView>(R.id.superhero_name_3).text = superHeros[2].name
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            val superHero3: SuperHero? = viewModel.itemSelected(superHeros[2].id)
            superHero3?.let {
                Log.d("@dev", "Super Heroe seleccionado: ${it.name}")
            }
        }

    }
}