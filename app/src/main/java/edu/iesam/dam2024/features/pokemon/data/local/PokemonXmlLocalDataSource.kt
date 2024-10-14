package edu.iesam.dam2024.features.pokemon.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonXmlLocalDataSource(context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
    )
    private val gson = Gson()

    fun save(pokemon:Pokemon){
        sharedPref.edit().apply(){
            putString("id", pokemon.id)
            putString("name", pokemon.name)
            putString("image", pokemon.image)
            putString("poderes", pokemon.poderes.toString())
            apply()
        }
    }
    fun saveAll(pokemons:List<Pokemon>){
        val editor = sharedPref.edit()
        pokemons.forEach{pokemon->
            editor.putString(pokemon.id, gson.toJson(pokemon))
        }
        editor.apply()
    }

    fun findAll():List<Pokemon>{
        val pokemons = ArrayList<Pokemon>()
        val mapPokemon= sharedPref.all as Map<String,String>
        mapPokemon.values.forEach { jsonPokemon ->
            val pokemon = gson.fromJson(jsonPokemon, Pokemon::class.java)
            pokemons.add(pokemon)
        }
        return pokemons
    }

    fun findById(pokemonId:String):Pokemon?{
        return sharedPref.getString(pokemonId, null).let { pokemon->
            gson.fromJson(pokemon, Pokemon::class.java)
        }
    }

    fun delete(){
        sharedPref.edit().clear().apply()
    }

    fun deleteById(pokmeonId:String){
        sharedPref.edit().remove(pokmeonId).apply()
    }


}