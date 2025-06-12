package com.example.modul5.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.modul5.data.AppDatabase
import com.example.modul5.data.Movie
import com.example.modul5.data.MovieDetails
import com.example.modul5.data.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(application: Application) : ViewModel() {

    private val repository: MovieRepository
    val movies: LiveData<List<Movie>>

    // StateFlow untuk film yang dipilih dari daftar
    private val _selectedMovie = MutableStateFlow<Movie?>(null)
    val selectedMovie: StateFlow<Movie?> = _selectedMovie

    // --- STATEFLOW BARU UNTUK MENAMPUNG DETAIL LENGKAP ---
    private val _movieDetails = MutableStateFlow<MovieDetails?>(null)
    val movieDetails: StateFlow<MovieDetails?> = _movieDetails

    init {
        val movieDao = AppDatabase.getDatabase(application).movieDao()
        repository = MovieRepository(movieDao)
        movies = repository.movies.asLiveData()
        refreshDataFromRepository()
    }

    private fun refreshDataFromRepository() {
        viewModelScope.launch {
            repository.refreshMovies()
        }
    }

    fun selectMovie(movie: Movie) {
        _selectedMovie.value = movie
        // Saat film dipilih, langsung ambil detail lengkapnya
        fetchMovieDetails(movie.id)
    }

    // --- FUNGSI BARU UNTUK MENGAMBIL DETAIL ---
    private fun fetchMovieDetails(movieId: Int) {
        viewModelScope.launch {
            // Set null dulu agar UI menampilkan loading (jika ada)
            _movieDetails.value = null
            // Panggil repository untuk mendapatkan detail
            val details = repository.getMovieDetails(movieId)
            _movieDetails.value = details
        }
    }
}
