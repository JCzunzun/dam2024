package edu.iesam.dam2024.features.superHero.data.local


import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superHero.domain.SuperHero

class SuperHeroXmlLocalDataSource(context: Context) {
    /* private val sharedPref = context.getSharedPreferences(
         context.getString(R.string.name_file_xml), Context.MODE_PRIVATE
     )
     private val gson = Gson()

     fun save(superHero: SuperHero) {
         sharedPref.edit().apply {
             putString("id", superHero.id)
             putString("name", superHero.name)
             putString("slug", superHero.slug)
             apply()
         }
     }

     fun saveAll(superHeros: List<SuperHero>) {
         val editor = sharedPref.edit()
         superHeros.forEach { superHero ->
             editor.putString(superHero.id, gson.toJson(superHero))
         }
         editor.apply()
     }

     fun findAll(): List<SuperHero> {
         val superHeros = ArrayList<SuperHero>()
         val mapSuperHeros = sharedPref.all as Map<String, String>
         mapSuperHeros.values.forEach { jsonSuperHeros ->
             val superHero = gson.fromJson(jsonSuperHeros, SuperHero::class.java)
         }
         return superHeros
     }

     fun findById(superHeroId: String): SuperHero {
         return sharedPref.getString(superHeroId, null).let { superHero ->
             gson.fromJson(superHero, SuperHero::class.java)
         }
     }

     fun delete() {
         sharedPref.edit().clear().apply()
     }

     fun deleteById(superHeroId: String) {
         sharedPref.edit().remove(superHeroId).apply()
     }*/
}