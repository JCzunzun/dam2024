package edu.iesam.dam2024.features.movies.domain

import edu.iesam.dam2024.features.movies.data.local.MovieXMLLocalDataSource
import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource

class MovieDataRepository(
    private val local: MovieXMLLocalDataSource,
    private val mockRemoteDataSource: MovieMockRemoteDataSource
) :
    MovieRepository {

    override fun getMovies(): List<Movie> {
        return mockRemoteDataSource.getMovies()
    }

    override fun getMovie(movieId: String): Movie? {
        return mockRemoteDataSource.getMovie(movieId)
    }

}