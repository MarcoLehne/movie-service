package com.movieapp.MovieApp.datasource.mock

import com.movieapp.MovieApp.model.User
import com.movieapp.MovieApp.model.UserDeleteRequest
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
}