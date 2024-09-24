package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieActivity : AppCompatActivity() {

    private val movieFactory: MovieFactory = MovieFactory()
    private val viewModel = movieFactory.buildViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movies = viewModel.viewCreated()
        bindDate(movies)
        Log.d("@dev", movies.toString())
    }

    private fun bindDate(movies: List<Movie>) {
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_tittle_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            val movie1: Movie? = viewModel.itemSelected(movies[0].id)
            movie1?.let {
                Log.d("@dev", "Pelicula seleccionada: ${it.title}")
            }
        }
        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_tittle_2).text = movies[1].title

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_tittle_3).text = movies[2].title

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_tittle_4).text = movies[3].title



    }
}