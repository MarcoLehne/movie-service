package com.movieapp.MovieApp.datasource.mock

import com.movieapp.MovieApp.datasource.MovieDataSource
import com.movieapp.MovieApp.datasource.UserActionDataSource
import com.movieapp.MovieApp.datasource.UserDataSource
import com.movieapp.MovieApp.datasource.UserStateDataSource
import com.movieapp.MovieApp.model.*
import org.springframework.stereotype.Repository

@Repository
class MockUserActionDataSource(
    val userStateDataSource: UserStateDataSource,
    val movieDataSource: MovieDataSource,
    val userDataSource: UserDataSource
) : UserActionDataSource {

    override fun favoriteMovie(movieFavoriteRequest: MovieFavoriteRequest): User {
        val userUpdateRequest = UserUpdateRequest(
            movieFavoriteRequest.userToken,
            "favoriteMovies",
            movieFavoriteRequest.movie,
            "add"
        )

        return userDataSource.updateUser(userUpdateRequest)
    }


    override fun createMovie(movieCreateRequest: MovieCreateRequest): Movie? {
        if ( movieDataSource.retrieveMovies().all { it.title != movieCreateRequest.movie.title } ) {
            return movieDataSource.createMovie(movieCreateRequest.movie)
        }
        else return null
    }

    override fun rateMovie(movieRatingRequest: MovieRatingRequest): Movie {

        if ( movieRatingRequest.rating !in 0..5) throw IllegalArgumentException("Rating was not in Int range 0 .. 5")

        var movieToBeRated = movieDataSource.retrieveMovies().find { it.title == movieRatingRequest.movie.title }
        if ( movieToBeRated!!.amountOfRatings == 0) {

            movieToBeRated.rating = movieRatingRequest.rating.toDouble()
            movieToBeRated.amountOfRatings = 1
        } else {
            val oldMultipliedRating = movieToBeRated.rating!! * movieToBeRated.amountOfRatings
            movieToBeRated.amountOfRatings += 1
            movieToBeRated.rating = (oldMultipliedRating + movieRatingRequest.rating.toDouble()) / movieToBeRated.amountOfRatings
        }
        return movieToBeRated
    }

    override fun retrieveMovieDataSource(): MovieDataSource {
        return movieDataSource
    }

    override fun retrieveUserDataSource(): UserDataSource {
        return userDataSource
    }

    override fun retrieveUserStateDataSource(): UserStateDataSource {
        return userStateDataSource
    }
}