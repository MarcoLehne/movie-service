package com.movieapp.MovieApp.datasource.mock

import com.movieapp.MovieApp.model.Movie
import com.movieapp.MovieApp.model.MovieRatingRequest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.test.annotation.DirtiesContext
import kotlin.random.Random

class MockMovieDataSourceTest {

    private val mockMovieDataSource = MockMovieDataSource()

    @Test
    fun `should provide a collection of movies`() {

        val movies = mockMovieDataSource.retrieveMovies()

        Assertions.assertThat(movies.size).isGreaterThanOrEqualTo(3)
    }

//
//    @Test
//    @DirtiesContext
//    fun `should add a rating to a movie`() {
//        val movieRatingRequest = MovieRatingRequest(
//            movie = Movie("2001: A Space Odyssey",
//            "04-02-1968",
//            "Stanley Kubrick",
//            null,
//            0
//            ),
//            rating = 5
//        )
//
//        mockMovieDataSource.rateMovie(movieRatingRequest)
//        val ratedMovie = mockMovieDataSource.retrieveMovies().find { it.title == movieRatingRequest.movie.title }
//
//        Assertions.assertThat(ratedMovie!!.rating).isEqualTo(5.0)
//        Assertions.assertThat(ratedMovie!!.amountOfRatings).isEqualTo(1)
//    }
//
//    @Test
//    @DirtiesContext
//    fun `should correctly calculate average of several ratings`() {
//        var movieRatingRequest = MovieRatingRequest(
//            movie = Movie("2001: A Space Odyssey",
//                "04-02-1968",
//                "Stanley Kubrick",
//                null,
//                0
//            ),
//            rating = 0
//        )
//
//        var ratings = mutableListOf<Int>()
//
//        for (i in 1..10) {
//            val randomRating = Random.nextInt(1, 6)
//            ratings.add(randomRating)
//            movieRatingRequest.rating = randomRating
//            mockMovieDataSource.rateMovie(movieRatingRequest)
//        }
//
//        val averageRating = ratings.fold(0) { acc,rating ->  acc + rating }.toDouble() / ratings.size
//
//        Assertions.assertThat(mockMovieDataSource.retrieveMovie(movieRatingRequest.movie)!!.rating == averageRating)
//        Assertions.assertThat(mockMovieDataSource.retrieveMovie(movieRatingRequest.movie)!!.amountOfRatings == ratings.size)
//    }
}