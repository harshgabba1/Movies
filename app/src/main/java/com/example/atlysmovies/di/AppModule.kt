package com.example.atlysmovies.di

import com.example.atlysmovies.domain.MovieRepository
import com.example.atlysmovies.data.MovieRepositoryImpl
import com.example.atlysmovies.data.TmdbApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideBaseUrl() = "https://api.themoviedb.org/3/"


    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideTmdbApi(retrofit: Retrofit): TmdbApi = retrofit.create(TmdbApi::class.java)


    @Provides
    @Singleton
    fun provideRepository(api: TmdbApi): MovieRepository = MovieRepositoryImpl(api)
}