package com.example.modul5.data

import android.util.Log
import com.example.modul5.networking.ApiClient
import kotlinx.coroutines.flow.Flow

class MovieRepository(private val movieDao: MovieDao) {

    val movies: Flow<List<Movie>> = movieDao.getAllMovies()

    suspend fun refreshMovies() {
        try {
            val response = ApiClient.instance.getPopularMovies()
            movieDao.deleteAll()
            movieDao.insertAll(response.results)
        } catch (e: Exception) {
            Log.e("MovieRepository", "Error refreshing movies: ${e.message}")
        }
    }

    // --- FUNGSI BARU UNTUK MENGAMBIL DETAIL DARI INTERNET ---
    suspend fun getMovieDetails(movieId: Int): MovieDetails? {
        return try {
            ApiClient.instance.getMovieDetails(movieId)
        } catch (e: Exception) {
            Log.e("MovieRepository", "Error getting movie details: ${e.message}")
            null
        }
    }
}
