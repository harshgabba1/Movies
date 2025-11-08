package com.example.atlysmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repo: MovieRepository
) : ViewModel() {


    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies


    fun fetchTrending() {
        viewModelScope.launch {
            _movies.value = repo.getTrendingMovies()
        }
    }


    fun search(query: String) {
        viewModelScope.launch {
            _movies.value = if (query.isNotEmpty()) repo.searchMovies(query) else repo.getTrendingMovies()
        }
    }
}