package com.movieapp.MovieApp.service

import com.movieapp.MovieApp.datasource.UserDataSource
import com.movieapp.MovieApp.model.*
import org.springframework.stereotype.Service

@Service
class UserDataService(private val dataSource: UserDataSource) {

    fun retrieveUsers(): MutableList<User> {
        return dataSource.retrieveUsers()
    }

    fun createUser(user: User): User? {
        return dataSource.createUser(user)
    }

    fun deleteUser(userDeleteRequest: UserDeleteRequest): User? {
        return dataSource.deleteUser(userDeleteRequest)
    }
}