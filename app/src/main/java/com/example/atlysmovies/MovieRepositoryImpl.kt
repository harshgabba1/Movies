package com.example.atlysmovies

import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: TmdbApi
) : MovieRepository {


    private val apiKey = "c1826d708b46207c8347f042cb9fed6d"


    override suspend fun getTrendingMovies(): List<Movie> =
        api.getTrendingMovies(apiKey = apiKey).results


    override suspend fun searchMovies(query: String): List<Movie> =
        api.searchMovies(query, apiKey = apiKey).results
}