// File: networking/ApiClient.kt
package com.example.modul5.networking

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object ApiClient {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    // PENTING: Masukkan API Read Access Token Anda di sini
    private const val API_READ_ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxMzY5MDE0ZDJjYjkxNjIzOWY1NjdkMWUwZWZmZDUzNiIsIm5iZiI6MTc0OTcwNjcyNi4yMiwic3ViIjoiNjg0YTY3ZTYyNGMzOWVmNGU1MWViYTIyIiwic2NvcGVzIjpbImFwaV9yZWFkIl0sInZlcnNpb24iOjF9.Aojt3CY11RJ5kjNKHHHGxKedOWNHzbvnqJ_1LBJ34TY"

    private val json = Json {
        ignoreUnknownKeys = true
    }

    val instance: ApiService by lazy {
        // 1. Buat Interceptor untuk menambahkan header secara otomatis
        val authInterceptor = Interceptor { chain ->
            val originalRequest = chain.request()
            val newRequest = originalRequest.newBuilder()
                .header("Authorization", "Bearer $API_READ_ACCESS_TOKEN")
                .header("accept", "application/json")
                .build()
            chain.proceed(newRequest)
        }

        // 2. Buat OkHttpClient dan tambahkan interceptor
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()

        // 3. Buat instance Retrofit dengan OkHttpClient yang sudah dimodifikasi
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient) // Gunakan client custom kita
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

        retrofit.create(ApiService::class.java)
    }
}
