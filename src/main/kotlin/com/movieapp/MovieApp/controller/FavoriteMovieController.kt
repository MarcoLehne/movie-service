package com.movieapp.MovieApp.controller

import com.movieapp.MovieApp.model.Movie
import com.movieapp.MovieApp.model.MovieFavoriteRequest
import com.movieapp.MovieApp.model.User
import com.movieapp.MovieApp.service.UserActionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/favoriteMovie")
class FavoriteMovieController(
    private val service: UserActionService
) {

    @PostMapping
    fun favoriteMovie(@RequestBody favoriteMovieRequest: MovieFavoriteRequest): ResponseEntity<User> {

        val performFavoriteMovie = service.favoriteMovie(favoriteMovieRequest)

        if (performFavoriteMovie != null ) return ResponseEntity.ok(performFavoriteMovie)
        else return ResponseEntity.ok(null)
    }
}