package com.movieapp.MovieApp.datasource

import com.movieapp.MovieApp.model.Movie
import com.movieapp.MovieApp.model.MovieCreateRequest
import com.movieapp.MovieApp.model.MovieFavoriteRequest
import com.movieapp.MovieApp.model.MovieRatingRequest

interface UserActionDataSource {
    fun createMovie(movieCreateRequest: MovieCreateRequest): Movie?
    fun rateMovie(movieRatingRequest: MovieRatingRequest): Movie
    fun favoriteMovie(movieFavoriteRequest: MovieFavoriteRequest): Movie?
    fun retrieveMovieDataSource(): MovieDataSource
    fun retrieveUserDataSource(): UserDataSource
    fun retrieveUserStateDataSource(): UserStateDataSource
}