package edu.iesam.dam2024.features.movies.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie

class MovieMockRemoteDataSource {
    private val movies = listOf(
        Movie("1: ", "Pedro", "https://i.blogs.es/0b6614/el-hoyo-2-escena/1200_800.jpeg"),
        Movie("2: ", "Paco", "https://i.blogs.es/0b6614/el-hoyo-2-escena/1200_800.jpeg"),
        Movie("3: ", "Pablo", "https://i.blogs.es/0b6614/el-hoyo-2-escena/1200_800.jpeg."),
        Movie(title = "title4", poster = "poster4", id = "4")

    )

    fun getMovies(): List<Movie> {
        return movies
    }

    fun getMovie(movieId: String): Movie? {
        return movies.firstOrNull { movie ->
            movie.id == movieId
        }
    }

}