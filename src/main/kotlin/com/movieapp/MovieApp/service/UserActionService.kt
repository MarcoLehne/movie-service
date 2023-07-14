package com.movieapp.MovieApp.service

import com.movieapp.MovieApp.datasource.UserActionDataSource
import com.movieapp.MovieApp.model.*
import org.springframework.stereotype.Service

@Service
class UserActionService(private val dataSource: UserActionDataSource) {

    fun createMovie(movieCreateRequest: MovieCreateRequest): Movie? {
        return dataSource.createMovie(movieCreateRequest)
    }

    fun rateMovie(movieRatingRequest: MovieRatingRequest): Movie {
        return dataSource.rateMovie(movieRatingRequest)
    }

    fun favoriteMovie(movieFavoriteRequest: MovieFavoriteRequest): User {
        return dataSource.favoriteMovie(movieFavoriteRequest)
    }
}