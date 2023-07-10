package com.movieapp.MovieApp.service

import com.movieapp.MovieApp.datasource.UserActionDataSource
import com.movieapp.MovieApp.model.Movie
import com.movieapp.MovieApp.model.MovieCreateRequest
import com.movieapp.MovieApp.model.MovieFavoriteRequest
import com.movieapp.MovieApp.model.MovieRatingRequest
import org.springframework.stereotype.Service

@Service
class UserActionService(private val dataSource: UserActionDataSource) {

    fun createMovie(movieCreateRequest: MovieCreateRequest): Movie? {
        return dataSource.createMovie(movieCreateRequest)
    }

    fun rateMovie(movieRatingRequest: MovieRatingRequest): Movie {
        return dataSource.rateMovie(movieRatingRequest)
    }

    fun favoriteMovie(movieFavoriteRequest: MovieFavoriteRequest): Movie? {
        return dataSource.favoriteMovie(movieFavoriteRequest)
    }
}