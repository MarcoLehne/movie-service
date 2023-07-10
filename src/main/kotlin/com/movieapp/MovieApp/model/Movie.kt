package com.movieapp.MovieApp.model

data class Movie(
    val title: String,
    val releaseDate: String,
    val director: String,
    var rating: Double?,
    var amountOfRatings: Int
)
