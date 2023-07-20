package com.movieapp.MovieApp.datasource.mock

import com.movieapp.MovieApp.datasource.UserDataSource
import com.movieapp.MovieApp.model.*
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository

@Repository
class MockUserDataSource(
    private val passwordEncoder: PasswordEncoder
) : UserDataSource{

    var users = mutableListOf(
        User(
            "stargazer74",
            "gnitset_rof_tlas_dexif32ujj",
            ratedMovies = mutableListOf(),
            favoriteMovies = mutableListOf()
        ),
        User(
            "fluffypuff69",
            "gnitset_rof_tlas_dexif999uwuww",
            ratedMovies = mutableListOf(Movie(
                "Harry Potter and the Philosopher's Stone",
                "11-22-2001",
                "Chris Columbus",
                5.0,
                1
            ),),
            favoriteMovies = mutableListOf(Movie(
                "Harry Potter and the Philosopher's Stone",
                "11-22-2001",
                "Chris Columbus",
                5.0,
                1
            ),)
        ),
        User(
            "twistingShadow1",
            "gnitset_rof_tlas_dexif5uj555",
            ratedMovies = mutableListOf(),
            favoriteMovies = mutableListOf()
        )
    )


    override fun retrieveUsers(): MutableList<User> {
        return users
    }

    override fun retrieveUser(userName: String): User {
        return users.find { it.userName == userName }!!
    }

    override fun createUser(user: User): User? {
        if ( users.all { it.userName != user.userName } ) {
            user.password = passwordEncoder.encode(user.password)
            users.add(user)
            return user
        }
        else return null
    }

    override fun deleteUser(userDeleteRequest: UserDeleteRequest): User? {
        val userToBeRemoved =
            users.find {
                           it.userName == userDeleteRequest.userName &&
                           it.password == passwordEncoder.encode(userDeleteRequest.password)
        }

        users.remove(userToBeRemoved)

        return userToBeRemoved
    }

    override fun updateUser(userUpdateRequest: UserUpdateRequest): User {
        val userToUpdate = retrieveUser(userUpdateRequest.userToken.userName)
        val updateFavoriteOrRatedMovies = userUpdateRequest.updateFavoriteMoviesOrRatedMovies
        val movie = userUpdateRequest.movie
        val addOrDelete = userUpdateRequest.addOrDelete

        if ( addOrDelete == "add") {
            if (updateFavoriteOrRatedMovies == "favoriteMovies") userToUpdate.favoriteMovies.add(movie)
            else userToUpdate.ratedMovies.add(movie)
        } else {
            if (updateFavoriteOrRatedMovies == "favoriteMovies") userToUpdate.favoriteMovies.removeIf {
                it.title == movie.title
            }
            else userToUpdate.ratedMovies.removeIf { it.title == movie.title}
        }

        return userToUpdate
    }
}