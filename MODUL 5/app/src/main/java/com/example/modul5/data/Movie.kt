@file:OptIn(InternalSerializationApi::class)

package com.example.modul5.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.OptIn

// Kelas untuk daftar film (tetap sama)
@Serializable
@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey
    val id: Int,
    val title: String,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("overview")
    val overview: String
)

// Wrapper untuk daftar film populer
@Serializable
data class MovieResponse(
    val results: List<Movie>
)

//--- KELAS-KELAS BARU UNTUK DETAIL FILM ---

// Kelas utama untuk detail film
@Serializable
data class MovieDetails(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("release_date")
    val releaseDate: String?,
    val credits: Credits,
    val videos: VideoResponse
)

// Kelas untuk kredit (aktor dan kru)
@Serializable
data class Credits(
    val cast: List<CastMember>,
    val crew: List<CrewMember>
)

// Kelas untuk anggota cast (aktor)
@Serializable
data class CastMember(
    val name: String,
    val character: String
)

// Kelas untuk anggota kru (sutradara, dll)
@Serializable
data class CrewMember(
    val name: String,
    val job: String
)

// Wrapper untuk daftar video/trailer
@Serializable
data class VideoResponse(
    val results: List<Video>
)

// Kelas untuk satu video/trailer
@Serializable
data class Video(
    val key: String,
    val site: String,
    val type: String
)
