package edu.iesam.dam2024.features.movies.domain

import edu.iesam.dam2024.features.movies.data.local.MovieXMLLocalDataSource
import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource

class MovieDataRepository(
    private val local: MovieXMLLocalDataSource,
    private val mockRemoteDataSource: MovieMockRemoteDataSource
) :
    MovieRepository {

    override fun getMovies(): List<Movie> {
        val moviesFromLocal = local.findAll()
        if (moviesFromLocal.isEmpty()) {
            val moviesFromRemote = mockRemoteDataSource.getMovies()
            local.saveAll(moviesFromRemote)
            return moviesFromRemote
        } else {
            return moviesFromLocal
        }
    }

    override fun getMovie(movieId: String): Movie? {
        val localMovie = local.findById(movieId)
        if (localMovie == null) {
            mockRemoteDataSource.getMovie(movieId)?.let {
                local.save(it)
                return it
            }
        }
        return localMovie
    }

}