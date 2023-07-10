package com.movieapp.MovieApp.datasource.mock

import com.movieapp.MovieApp.datasource.UserDataSource
import com.movieapp.MovieApp.model.*
import org.springframework.stereotype.Repository

@Repository
class MockUserDataSource : UserDataSource{

    var users = mutableListOf(
        User(
            "stargazer74",
            "jju23",
            ratedMovies = mutableListOf(),
            favoriteMovies = mutableListOf()
        ),
        User(
            "fluffypuff69",
            "wwuwu999",
            ratedMovies = mutableListOf(),
            favoriteMovies = mutableListOf()
        ),
        User(
            "twistingShadow1",
            "555ju5",
            ratedMovies = mutableListOf(),
            favoriteMovies = mutableListOf()
        )
    )


    override fun retrieveUsers(): MutableList<User> {
        return users
    }

    override fun createUser(user: User): User? {
        if ( users.all { it.userName != user.userName } ) {
            users.add(user)
            return user
        }
        else return null
    }

    override fun deleteUser(userDeleteRequest: UserDeleteRequest): User? {

        val userToBeRemoved =
            users.find {
                           it.userName == userDeleteRequest.userName &&
                           it.password == userDeleteRequest.password
        }

        users.remove(userToBeRemoved)

        return userToBeRemoved
    }

}