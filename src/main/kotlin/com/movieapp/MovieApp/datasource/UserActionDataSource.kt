package com.movieapp.MovieApp.datasource

import com.movieapp.MovieApp.model.*

interface UserActionDataSource {
    fun createMovie(movieCreateRequest: MovieCreateRequest): Movie?
    fun rateMovie(movieRatingRequest: MovieRatingRequest): Movie
    fun favoriteMovie(movieFavoriteRequest: MovieFavoriteRequest): User
    fun retrieveMovieDataSource(): MovieDataSource
    fun retrieveUserDataSource(): UserDataSource
    fun retrieveUserStateDataSource(): UserStateDataSource
}