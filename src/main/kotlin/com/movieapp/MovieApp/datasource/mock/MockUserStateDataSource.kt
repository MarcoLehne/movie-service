package com.movieapp.MovieApp.datasource.mock

import com.fasterxml.jackson.databind.ObjectMapper
import com.movieapp.MovieApp.datasource.UserDataSource
import com.movieapp.MovieApp.datasource.UserStateDataSource
import com.movieapp.MovieApp.model.*
import org.springframework.stereotype.Repository

@Repository
class MockUserStateDataSource(
    private val userDataSource: UserDataSource
): UserStateDataSource {

    val loggedInUsers = mutableListOf(
        UserToken(
            "stargazer74",
            "1"
        ),
        UserToken(
            "fluffypuff69",
            "1"
        )
    )

    override fun loginUser(userLoginRequest: UserLoginRequest): UserToken? {

        val isUserLoggedIn = loggedInUsers.any { it.userName == userLoginRequest.userName }
        val user = userDataSource.retrieveUser(userLoginRequest.userName)
        val isPWCorrect = user?.password == userLoginRequest.password

        if ( ! isUserLoggedIn && isPWCorrect  ) {

            val newUserToken = UserToken(userLoginRequest.userName, "1")

            loggedInUsers.add( newUserToken )

            return newUserToken

        } else return null
    }

    override fun logoutUser(userToken: UserToken): Boolean {
        loggedInUsers.remove(userToken)
        return true
    }

    override fun verifyUser(userToken: UserToken): Boolean = loggedInUsers.any { it == userToken }

    override fun retrieveUserDataSource(): UserDataSource = userDataSource
}