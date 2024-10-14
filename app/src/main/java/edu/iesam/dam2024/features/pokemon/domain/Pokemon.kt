package edu.iesam.dam2024.features.pokemon.domain

data class Pokemon(
        val id:String,
        val image :String,
        val name : String,
        val tipo:String,
        val poderes:Poderes
)
data class Poderes(
    val poder1:String,
    val poder2:String,
    val poder3:String,
    val poder4:String
)