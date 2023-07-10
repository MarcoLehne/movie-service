package com.movieapp.MovieApp.datasource.mock

import com.movieapp.MovieApp.datasource.MovieDataSource
import com.movieapp.MovieApp.datasource.UserActionDataSource
import com.movieapp.MovieApp.datasource.UserDataSource
import com.movieapp.MovieApp.datasource.UserStateDataSource
import com.movieapp.MovieApp.model.Movie
import com.movieapp.MovieApp.model.MovieCreateRequest
import com.movieapp.MovieApp.model.MovieFavoriteRequest
import com.movieapp.MovieApp.model.MovieRatingRequest
import org.springframework.stereotype.Repository

@Repository
class MockUserActionDataSource(
    val userStateDataSource: UserStateDataSource,
    val movieDataSource: MovieDataSource
) : UserActionDataSource {


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

    override fun favoriteMovie(movieFavoriteRequest: MovieFavoriteRequest): Movie? {
        var userToUpdate = userStateDataSource.retrieveUserDataSource().retrieveUsers().find { it.userName == movieFavoriteRequest.userToken.userName }
        if (userToUpdate!!.favoriteMovies.contains(movieFavoriteRequest.movie)) return null
        else {
            userToUpdate.favoriteMovies.add(movieFavoriteRequest.movie)
            return movieFavoriteRequest.movie
        }
    }

    override fun retrieveMovieDataSource(): MovieDataSource {
        return movieDataSource
    }

    override fun retrieveUserDataSource(): UserDataSource {
        return userStateDataSource.retrieveUserDataSource()
    }

    override fun retrieveUserStateDataSource(): UserStateDataSource {
        return userStateDataSource
    }
}