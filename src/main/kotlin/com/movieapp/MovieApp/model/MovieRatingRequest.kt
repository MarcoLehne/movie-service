package com.movieapp.MovieApp.model

data class MovieRatingRequest(
    val movie: Movie,
    val userToken: UserToken,
    var rating: Int
)
