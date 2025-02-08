package com.example.pobreflix.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pobreflix.data.AppDatabase
import com.example.pobreflix.data.MovieEntity
import com.example.pobreflix.data.MovieRepository
import com.example.pobreflix.data.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: MovieRepository

    // StateFlow para armazenar a lista de filmes
    private val _movies = MutableStateFlow<List<MovieEntity>>(emptyList())
    val movies: StateFlow<List<MovieEntity>> = _movies

    init {
        val movieDao = AppDatabase.getDatabase(application).movieDao()
        repository = MovieRepository(movieDao, RetrofitInstance.api) // Adicionado RetrofitInstance.api

        loadAllMovies() // Carregar filmes automaticamente
    }

    private fun loadAllMovies() {
        viewModelScope.launch {
            _movies.value = repository.getAllMovies()
        }
    }

    fun searchMovies(query: String) {
        viewModelScope.launch {
            _movies.value = repository.getSearchMovies(query)
        }
    }

    fun insertMovie(movie: MovieEntity) {
        viewModelScope.launch {
            repository.insertMovie(movie)
            loadAllMovies() // Atualiza a lista de filmes após inserção
        }
    }

    fun getMovieById(id: Int, callback: (MovieEntity?) -> Unit) {
        viewModelScope.launch {
            val movie = repository.getMovieById(id)
            callback(movie)
        }
    }

    class MovieViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MovieViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
