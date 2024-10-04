package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
     val uiState : LiveData<UiState> = _uiState
    fun viewCreated(){
        viewModelScope.launch (Dispatchers.IO) {
            val movies = getMoviesUseCase.invoke()
            _uiState.postValue(UiState(movies= movies))
        }

    }
    fun itemSelected(movieid: String): Movie? {
        return getMovieUseCase.invoke(movieid)
    }
    data class UiState(
        val isLoading :Boolean = false,
        val errorApp: ErrorApp? = null,
        val movies :List<Movie>? = null
    )
}