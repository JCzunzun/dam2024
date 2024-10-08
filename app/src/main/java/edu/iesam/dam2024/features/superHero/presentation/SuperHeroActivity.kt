package edu.iesam.dam2024.features.superHero.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superHero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superHero.domain.SuperHero


class SuperHeroActivity : AppCompatActivity() {
    private lateinit var xmlLocalDataSource: SuperHeroXmlLocalDataSource
    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        xmlLocalDataSource = SuperHeroXmlLocalDataSource(this)
        superHeroFactory= SuperHeroFactory(this)
        viewModel = superHeroFactory.buildViewModel()
        viewModel.viewCreated()



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

    private fun bindData(superHeros: List<SuperHero>){

    }


    private fun whenError(error: ErrorApp){
        when(error){
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
        }
    }

}