package edu.iesam.dam2024.features.movies.presentation

sealed class ErrorApp {
    object InternetErrorApp: ErrorApp()
    object ServerErrorApp:ErrorApp()
    object DataErrorApp: ErrorApp()
    object UnknowErrorApp: ErrorApp()
}