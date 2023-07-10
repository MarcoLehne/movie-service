package com.movieapp.MovieApp.datasource

import com.movieapp.MovieApp.model.User
import com.movieapp.MovieApp.model.UserLoginRequest
import com.movieapp.MovieApp.model.UserToken

interface UserStateDataSource {
    fun loginUser(userLoginRequest: UserLoginRequest): UserToken?
    fun logoutUser(userToken: UserToken): Boolean
    fun verifyUser(userToken: UserToken): Boolean
    fun retrieveUserDataSource(): UserDataSource
}