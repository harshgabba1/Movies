package com.example.atlysmovies.data

import com.example.atlysmovies.data.ApiConstants.API_KEY
import com.example.atlysmovies.data.ApiConstants.EN_US
import com.example.atlysmovies.data.ApiConstants.LANGUAGE
import com.example.atlysmovies.data.ApiConstants.QUERY
import com.example.atlysmovies.data.ApiConstants.SEARCH_MOVIE_API
import com.example.atlysmovies.data.ApiConstants.TRENDING_MOVIE_WEEK_API
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {
    @GET(TRENDING_MOVIE_WEEK_API)
    suspend fun getTrendingMovies(
        @Query(LANGUAGE) language: String = EN_US,
        @Query(API_KEY) apiKey: String
    ): MovieResponse


    @GET(SEARCH_MOVIE_API)
    suspend fun searchMovies(
        @Query(QUERY) query: String,
        @Query(API_KEY) apiKey: String
    ): MovieResponse
}