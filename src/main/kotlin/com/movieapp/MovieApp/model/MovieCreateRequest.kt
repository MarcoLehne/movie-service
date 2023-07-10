package com.movieapp.MovieApp.model

data class MovieCreateRequest(
    val movie: Movie,
    val userToken: UserToken
)
