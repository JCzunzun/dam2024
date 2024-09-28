package edu.iesam.dam2024.features.movies.presentation


import android.content.Context
import edu.iesam.dam2024.features.movies.data.local.MovieXMLLocalDataSource
import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.MovieDataRepository

class MovieFactory(private val context: Context) {

    private val movieMockRemoteDataSource = MovieMockRemoteDataSource()
    private val movielLocal = MovieXMLLocalDataSource(context)
    private val movieDataRepository = MovieDataRepository(movielLocal, movieMockRemoteDataSource)
    private val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)
    private val getMovieUseCase = GetMovieUseCase(movieDataRepository)

    fun buildViewModel(): MovieViewModel {
        return MovieViewModel(getMoviesUseCase, getMovieUseCase)
    }

}