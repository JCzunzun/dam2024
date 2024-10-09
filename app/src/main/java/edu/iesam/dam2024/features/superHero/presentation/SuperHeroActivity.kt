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
    private lateinit var xmlLocalDataSource: SuperHeroXmlLocalDataSource
    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroViewModel
/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        xmlLocalDataSource = SuperHeroXmlLocalDataSource(this)
        superHeroFactory= SuperHeroFactory(this)
        viewModel = superHeroFactory.buildViewModel()
        viewModel.viewCreated()
        setUpObeserver()


    }
    private fun  setUpObeserver(){
        val superHeroObserver=
            androidx.lifecycle.Observer<SuperHeroViewModel.UiState> { uiState ->
                uiState.superHeros?.let {
                    bindData(it)
                }
                uiState.errorApp?.let {
                    //pinto error
                }
                if (uiState.isLoading) {
                    //muestro el cargando
                    Log.d("@dev", "Cargando ...")
                } else {
                    //oculto  el cargando
                    Log.d("@dev", "Cargando ...")
                }
            }
        viewModel.uiState.observe(this, superHeroObserver)
    }

    private fun bindData(superHeros: List<SuperHero>) {
        findViewById<TextView>(R.id.superhero_id_1).text = superHeros[0].id
        findViewById<TextView>(R.id.superhero_name_1).text = superHeros[0].name
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            navigateToSuperHeroDetail(superHeros[0].id)
        }

        findViewById<TextView>(R.id.superhero_id_2).text = superHeros[1].id
        findViewById<TextView>(R.id.superhero_name_2).text = superHeros[1].name
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            navigateToSuperHeroDetail(superHeros[1].id)
        }

        findViewById<TextView>(R.id.superhero_id_3).text = superHeros[2].id
        findViewById<TextView>(R.id.superhero_name_3).text = superHeros[2].name
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToSuperHeroDetail(superHeros[2].id)
        }

    }

    private fun navigateToSuperHeroDetail(superHeroId: String) {
        startActivity(SuperHeroDetailActivity.getIntent(this, superHeroId))
    }

    private fun whenError(error: ErrorApp){
        when(error){
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }
*/
}