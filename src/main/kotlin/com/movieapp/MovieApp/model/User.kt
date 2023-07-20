package com.movieapp.MovieApp.model

data class User(
    val userName: String,
    var password: String,
    var ratedMovies: MutableList<Movie>,
    var favoriteMovies: MutableList<Movie>
)
