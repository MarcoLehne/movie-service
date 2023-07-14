package com.movieapp.MovieApp.datasource.mock

import com.movieapp.MovieApp.model.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.test.annotation.DirtiesContext

class MockUserDataSourceTest {

    private val mockUserDataSource = MockUserDataSource()

    @Test
    @DirtiesContext
    fun `should create user`() {

        val user = User(
            "honeyman",
            "uuttt2",
            ratedMovies = mutableListOf(),
            favoriteMovies = mutableListOf()
        )

        val oldSizeOfUsers = mockUserDataSource.users.size
        mockUserDataSource.createUser(user)
        Assertions.assertThat(mockUserDataSource.users.size).isGreaterThan(oldSizeOfUsers)
    }

    @Test
    @DirtiesContext
    fun `should delete user`() {

        val userDeleteRequest = UserDeleteRequest(
            "stargazer74",
            "jju23"
        )

        val oldSizeOfUsers = mockUserDataSource.users.size
        mockUserDataSource.deleteUser(userDeleteRequest)
        Assertions.assertThat(mockUserDataSource.users.size).isLessThan(oldSizeOfUsers)
    }

    @Test
    @DirtiesContext
    fun `should add a favorite movie to a user`() {

        val userUpdateRequest = UserUpdateRequest(
            UserToken(
                "stargazer74",
                "1"
            ),
            "favoriteMovies",
            Movie(
                "Raiders of the Lost Ark",
                "06-12-81",
                "Steven Spielberg",
                null,
                0
            ),
            "add"
        )

        val oldFavoriteMovies = mockUserDataSource.users.find {
            it.userName == userUpdateRequest.userToken.userName
        }!!.favoriteMovies.toList()

        mockUserDataSource.updateUser(userUpdateRequest)

        val updatedFavoriteMovies = mockUserDataSource.users.find {
            it.userName == userUpdateRequest.userToken.userName
        }!!.favoriteMovies

        Assertions.assertThat(updatedFavoriteMovies.size).isGreaterThan(oldFavoriteMovies.size)
    }

    @Test
    @DirtiesContext
    fun `should add a rated movie to a user`() {

        val userUpdateRequest = UserUpdateRequest(
            UserToken(
                "stargazer74",
                "1"
            ),
            "ratedMovies",
            Movie(
                "Raiders of the Lost Ark",
                "06-12-81",
                "Steven Spielberg",
                null,
                0
            ),
            "add"
        )

        val oldRatedMovies = mockUserDataSource.users.find {
            it.userName == userUpdateRequest.userToken.userName
        }!!.ratedMovies.toList()

        mockUserDataSource.updateUser(userUpdateRequest)

        val updatedRatedMovies = mockUserDataSource.users.find {
            it.userName == userUpdateRequest.userToken.userName
        }!!.ratedMovies

        Assertions.assertThat(updatedRatedMovies.size).isGreaterThan(oldRatedMovies.size)
    }

    @Test
    @DirtiesContext
    fun `should delete a favorite movie from a user`() {

        val userUpdateRequest = UserUpdateRequest(
            UserToken(
                "fluffypuff69",
                "1"
            ),
            "favoriteMovies",
            Movie(
                "Harry Potter and the Philosopher's Stone",
                "11-22-2001",
                "Chris Columbus",
                5.0,
                1
            ),
            "delete"
        )

        val oldFavoriteMovies = mockUserDataSource.users.find {
            it.userName == userUpdateRequest.userToken.userName
        }!!.favoriteMovies.toList()

        mockUserDataSource.updateUser(userUpdateRequest)

        val updatedFavoriteMovies = mockUserDataSource.users.find {
            it.userName == userUpdateRequest.userToken.userName
        }!!.favoriteMovies

        Assertions.assertThat(updatedFavoriteMovies.size).isLessThan(oldFavoriteMovies.size)
    }

    @Test
    @DirtiesContext
    fun `should delete a rated movie from a user`() {

        val userUpdateRequest = UserUpdateRequest(
            UserToken(
                "fluffypuff69",
                "1"
            ),
            "ratedMovies",
            Movie(
                "Harry Potter and the Philosopher's Stone",
                "11-22-2001",
                "Chris Columbus",
                5.0,
                1
            ),
            "delete"
        )

        val oldRatedMovies = mockUserDataSource.users.find {
            it.userName == userUpdateRequest.userToken.userName
        }!!.ratedMovies.toList()

        mockUserDataSource.updateUser(userUpdateRequest)

        val updatedRatedMovies = mockUserDataSource.users.find {
            it.userName == userUpdateRequest.userToken.userName
        }!!.ratedMovies

        Assertions.assertThat(updatedRatedMovies.size).isLessThan(oldRatedMovies.size)
    }
}