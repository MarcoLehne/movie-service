package com.movieapp.MovieApp.model

data class UserLogoutRequest(
    val userName: String,
    val token: String)
