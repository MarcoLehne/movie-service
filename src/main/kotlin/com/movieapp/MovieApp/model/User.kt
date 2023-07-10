package com.movieapp.MovieApp.model

data class User(
    val userName: String, 
    val password: String,
    var ratedMovies: MutableList<Movie>,
    var favoriteMovies: MutableList<Movie>
)
