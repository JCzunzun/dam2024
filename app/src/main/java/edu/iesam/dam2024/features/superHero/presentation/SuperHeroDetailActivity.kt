package edu.iesam.dam2024.features.superHero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.loadUrl
import edu.iesam.dam2024.features.movies.presentation.MovieDetailViewModel
import edu.iesam.dam2024.features.superHero.domain.SuperHero

class SuperHeroDetailActivity : AppCompatActivity() {
    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_detail)
        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildSuperHeroDetailViewMovie()
        setUpObeserver()
        getSuperHeroId()?.let { superHeroId ->
            viewModel.viewCreated(superHeroId)?.let { superHero ->
                bindData(superHero)
            }
        }
    }

    private fun  setUpObeserver(){
        val superHeroObserver=
            androidx.lifecycle.Observer<SuperHeroDetailViewModel.UiState> { uiState ->
                uiState.superHero?.let {
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

    private fun getSuperHeroId(): String? {
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }

    private fun bindData(superHero: SuperHero) {
        val imageView = findViewById<ImageView>(R.id.imagen)
        imageView.loadUrl(superHero.images.sm)
    }

    companion object {
        val KEY_SUPERHERO_ID = "key_superhero_id"
        fun getIntent(context: Context, superHeroId: String): Intent {
            val intent = Intent(context, SuperHeroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHERO_ID, superHeroId)
            return intent
        }
    }
}