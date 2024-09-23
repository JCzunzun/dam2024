package edu.iesam.dam2024.features.movies.domain

import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource

class MovieDataRepository(private val mockRemoteDataSource: MovieMockRemoteDataSource) :
    MovieRepository {

    override fun getMovies(): List<Movie> {
        return mockRemoteDataSource.getMovies()
    }

}