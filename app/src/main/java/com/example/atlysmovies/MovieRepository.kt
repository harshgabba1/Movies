package com.example.atlysmovies

interface MovieRepository {
    suspend fun getTrendingMovies(): List<Movie>
    suspend fun searchMovies(query: String): List<Movie>
}