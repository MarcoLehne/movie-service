package com.movieapp.MovieApp.datasource.mock

import com.movieapp.MovieApp.model.UserLoginRequest
import com.movieapp.MovieApp.model.UserToken
import org.assertj.core.api.Assert
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.annotation.DirtiesContext

@SpringBootTest
class MockUserStateDataSourceTest(
    @Autowired private val passwordEncoder: PasswordEncoder
) {

    private val mockUserStateDataSource = MockUserStateDataSource(MockUserDataSource(passwordEncoder), passwordEncoder)

    @Test
    @DirtiesContext
    fun `should log user in`() {
        val userLoginRequest = UserLoginRequest(
            "twistingShadow1",
            "555ju5"
        )

        mockUserStateDataSource.loginUser(userLoginRequest)

        Assertions.assertThat(mockUserStateDataSource.loggedInUsers.find {
            it == UserToken("twistingShadow1", "1")
        }).isNotNull
    }

    @Test
    @DirtiesContext
    fun `should log user out`() {
        val userToken = UserToken(
            "stargazer74",
            "1"
        )

        mockUserStateDataSource.logoutUser(userToken)

        Assertions.assertThat(mockUserStateDataSource.loggedInUsers.find {
            it == UserToken("stargazer74", "1")
        }).isNull()
    }

    @Test
    fun `should verify logged in user`() {
        val userToken = UserToken(
            "stargazer74",
            "1"
        )

        Assertions.assertThat(mockUserStateDataSource.verifyUser(userToken)).isTrue()
    }

}