package com.movieapp.MovieApp.service

import com.movieapp.MovieApp.datasource.UserDataSource
import com.movieapp.MovieApp.datasource.UserStateDataSource
import com.movieapp.MovieApp.model.User
import com.movieapp.MovieApp.model.UserLoginRequest
import com.movieapp.MovieApp.model.UserToken
import org.springframework.stereotype.Service

@Service
class UserStateService(private val dataSource: UserStateDataSource) {

    fun loginUser(userLoginRequest: UserLoginRequest): UserToken? {
        return dataSource.loginUser(userLoginRequest)
    }

    fun logoutUser(userToken: UserToken): Boolean {
        return dataSource.logoutUser(userToken)
    }

    fun verifyUser(userToken: UserToken): Boolean {
        return dataSource.verifyUser(userToken)
    }

    fun retrieveUserDataSource(): UserDataSource {
        return dataSource.retrieveUserDataSource()
    }
}