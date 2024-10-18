package edu.iesam.dam2024.features.superHero.data.remote

import edu.iesam.dam2024.features.superHero.domain.SuperHero
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {
    //REST API, GET, POST, PUT, DELETE, PATCH

    @GET("all.json")
    suspend fun requestSuperHeros(): Response<List<SuperHero>>

    @GET("id/{id}.json")
    suspend fun requestSuperHero(@Path("id") id: String): Response<SuperHero>

}