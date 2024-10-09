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
    fun loadSuperHeros(){
        _uiState.value = (UiState(isLoading = true))
        viewModelScope.launch (Dispatchers.IO){
            val superHeros=getSuperHerosUseCase.invoke()
            _uiState.postValue(UiState(superHeros= superHeros))
        }

    }



    data class UiState(
        val isLoading : Boolean = false,
        val errorApp: ErrorApp? = null,
        val superHeros: List<SuperHero>?=null
    )

}