package com.example.modul5.networking

import com.example.modul5.data.MovieDetails
import com.example.modul5.data.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    // Endpoint untuk daftar film populer (tetap sama)
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): MovieResponse

    // --- FUNGSI BARU UNTUK MENDAPATKAN DETAIL FILM ---
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        // 'append_to_response' adalah trik API TMDB untuk mendapatkan
        // data kredit (aktor) dan video (trailer) dalam satu panggilan
        @Query("append_to_response") appendToResponse: String = "videos,credits"
    ): MovieDetails
}
