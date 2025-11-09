package com.example.atlysmovies.domain

import com.example.atlysmovies.data.Movie

interface MovieRepository {
    suspend fun getTrendingMovies(): List<Movie>
    suspend fun searchMovies(query: String): List<Movie>
}