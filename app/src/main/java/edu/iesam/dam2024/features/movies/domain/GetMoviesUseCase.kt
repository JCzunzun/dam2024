package edu.iesam.dam2024.features.movies.domain

import org.koin.core.annotation.Single

@Single
class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke(): List<Movie> {
        return movieRepository.getMovies()
    }

}