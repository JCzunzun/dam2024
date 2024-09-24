package edu.iesam.dam2024.features.SuperHero.domain

interface SuperHeroRepository {
    fun getSupeHero(): List<SuperHero>
}