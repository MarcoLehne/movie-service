package com.movieapp.MovieApp.datasource

import com.movieapp.MovieApp.model.*

interface UserDataSource {
    fun createUser(user: User): User?
    fun deleteUser(userDeleteRequest: UserDeleteRequest): User?
    fun retrieveUsers(): MutableList<User>
    fun updateUser(userUpdateRequest: UserUpdateRequest)
}