package edu.iesam.dam2024.features.pokemon.presentation

sealed class ErrorApp {
    object InternetErrorApp: ErrorApp()
    object ServerErrorApp:ErrorApp()
    object DataErrorApp: ErrorApp()
    object UnknowErrorApp: ErrorApp()
}