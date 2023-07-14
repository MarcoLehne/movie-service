package com.movieapp.MovieApp.model

data class UserUpdateRequest(
    val userToken: UserToken,
    val updateFavoriteMoviesOrRatedMovies: String,
    val movie: Movie,
    val addOrDelete: String
)
