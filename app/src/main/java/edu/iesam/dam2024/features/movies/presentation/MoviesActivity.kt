package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.data.local.MovieXMLLocalDataSource
import edu.iesam.dam2024.features.movies.domain.Movie

class MoviesActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)


    }



}