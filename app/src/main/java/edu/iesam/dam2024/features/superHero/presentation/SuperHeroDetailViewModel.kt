package edu.iesam.dam2024.features.superHero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.features.movies.presentation.ErrorApp
import edu.iesam.dam2024.features.superHero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superHero.domain.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperHeroDetailViewModel(
    private val getSuperHeroUseCase: GetSuperHeroUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun viewCreated(superHeroId: String) {
        viewModelScope.launch (Dispatchers.IO){
            val superHero= getSuperHeroUseCase.invoke(superHeroId)
            _uiState.postValue(UiState(superHero = superHero))
        }

    }
    data class UiState(
        val isLoading :Boolean = false,
        val errorApp: ErrorApp? = null,
        val superHero : SuperHero? = null
    )
}