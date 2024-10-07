package edu.iesam.dam2024.features.superHero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.features.superHero.domain.GetSuperHeroUseCase
import edu.iesam.dam2024.features.superHero.domain.GetSuperHerosUseCase
import edu.iesam.dam2024.features.superHero.domain.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SuperHeroViewModel(
    private val getSuperHerosUseCase: GetSuperHerosUseCase,
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState
    fun viewCreated(){
        viewModelScope.launch (Dispatchers.IO){
            getSuperHerosUseCase.invoke()

        }

    }

    data class UiState(
        val superHeroes: List<SuperHero> = emptyList()
    )

}