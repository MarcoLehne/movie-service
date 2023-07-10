package com.movieapp.MovieApp.controller

import com.movieapp.MovieApp.model.Movie
import com.movieapp.MovieApp.model.MovieCreateRequest
import com.movieapp.MovieApp.service.MovieService
import com.movieapp.MovieApp.service.UserActionService
import com.movieapp.MovieApp.service.UserStateService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/createMovie")
class CreateMovieController(
    private val userActionService: UserActionService,
    private val userStateService: UserStateService
) {

    @PostMapping
    fun createMovie(@RequestBody movieCreateRequest: MovieCreateRequest): ResponseEntity<Movie> {

        val isLoggedIn = userStateService.verifyUser(movieCreateRequest.userToken)
        if (! isLoggedIn ) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
        return ResponseEntity.ok(userActionService.createMovie(movieCreateRequest))
    }
}