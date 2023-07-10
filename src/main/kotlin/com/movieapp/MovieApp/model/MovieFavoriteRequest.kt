package com.movieapp.MovieApp.model

data class MovieFavoriteRequest(
    val movie: Movie,
    val userToken: UserToken
)
