package edu.iesam.dam2024.features.pokemon.data.remote

import androidx.lifecycle.MutableLiveData
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.API.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRemoteDataSource : ViewModel(){

    val pokemonList : MutableLiveData<List<Pokemon>> = MutableLiveData()

    fun getAll(){
        viewModelScope.launch{
            val call = RetrofitInstance.api.getAllPokemons()
            call.enqueue(object  : Callback<List<Pokemon>>{
                override fun onResponse(
                    call: Call<List<Pokemon>>,
                    response: Response<List<Pokemon>>
                ) {
                    if (response.isSuccessful){
                        pokemonList.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        }
    }
}