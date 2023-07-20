package com.movieapp.MovieApp.datasource.mock

import com.movieapp.MovieApp.model.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.annotation.DirtiesContext

@SpringBootTest
class MockUserActionDataSourceTest(
    @Autowired private val passwordEncoder: PasswordEncoder
) {

    private val mockUserActionDataSource = MockUserActionDataSource(
        MockUserStateDataSource(
            MockUserDataSource(passwordEncoder),
            passwordEncoder),
        MockMovieDataSource(),
        MockUserDataSource(passwordEncoder))
    private val mockMovieDataSource = mockUserActionDataSource.retrieveMovieDataSource()
    private val mockUserDataSource = mockUserActionDataSource.retrieveUserDataSource()

    @Test
    @DirtiesContext
    fun `should create new movie`() {

        val movieCreateRequest = MovieCreateRequest(
            Movie(
                "Iron Man",
                "5-1-2008",
                "Jon Favreau",
                null,
                0
            ),
            UserToken(
                "stargazer74",
                "1"
            )
        )

        val oldSizeOfMovies = mockMovieDataSource.retrieveMovies().size
        mockUserActionDataSource.createMovie(movieCreateRequest)
        Assertions.assertThat(mockMovieDataSource.retrieveMovies().size).isGreaterThan(oldSizeOfMovies)
    }


    @Test
    @DirtiesContext
    fun `should update movie rating`() {

        val movieRatingRequest = MovieRatingRequest(
            Movie(
                "Raiders of the Lost Ark",
                "06-12-81",
                "Steven Spielberg",
                null,
                0
            ),
            UserToken(
                "stargazer74",
                "1"
            ),
            rating = 4
        )

        val oldMovieEntry = mockMovieDataSource.retrieveMovies().find { it.title == movieRatingRequest.movie.title }
        val oldAmountOfRating = oldMovieEntry?.amountOfRatings

        val oldRatedMoviesSize = mockUserDataSource.retrieveUser(movieRatingRequest.userToken.userName).ratedMovies.size

        mockUserActionDataSource.rateMovie(movieRatingRequest)

        val newRatedMoviesSize = mockUserDataSource.retrieveUser(movieRatingRequest.userToken.userName).ratedMovies.size

        val newMovieEntry = mockMovieDataSource.retrieveMovies().find { it.title == movieRatingRequest.movie.title }
        val newRating = newMovieEntry?.rating
        val newAmountOfRating = newMovieEntry?.amountOfRatings

        Assertions.assertThat(newAmountOfRating).isGreaterThan(oldAmountOfRating)
        Assertions.assertThat(newRatedMoviesSize).isGreaterThan(oldRatedMoviesSize)
    }

    @Test
    @DirtiesContext
    fun `should calculate correct average rating`() {

        var movieRatingRequest = MovieRatingRequest(
            Movie(
                "Raiders of the Lost Ark",
                "06-12-81",
                "Steven Spielberg",
                null,
                0
            ),
            UserToken(
                "stargazer74",
                "1"
            ),
            rating = 4
        )

        for (i in listOf(3,4,3,4)) {
            movieRatingRequest.rating = i
            mockUserActionDataSource.rateMovie(movieRatingRequest)
        }

        val updatedMovieRating = mockMovieDataSource.retrieveMovies().find { it.title == movieRatingRequest.movie.title }!!.rating

        Assertions.assertThat(updatedMovieRating).isEqualTo(3.5)
    }

    @Test
    fun `should favorite a movie`() {

        val movieFavoriteRequest = MovieFavoriteRequest(
            Movie(
                "Raiders of the Lost Ark",
                "06-12-81",
                "Steven Spielberg",
                null,
                0
            ),
            UserToken(
                "stargazer74",
                "1"
            )
        )

        println(mockUserDataSource.retrieveUser(movieFavoriteRequest.userToken.userName))

        println(mockUserActionDataSource.favoriteMovie(movieFavoriteRequest))

        println(mockUserDataSource.retrieveUser(movieFavoriteRequest.userToken.userName))

        val updatedUser = mockUserDataSource.retrieveUser(movieFavoriteRequest.userToken.userName)
        Assertions.assertThat(updatedUser!!.favoriteMovies.first()).isEqualTo(movieFavoriteRequest.movie)
    }
}