package com.movieapp.MovieApp.controller

import com.movieapp.MovieApp.model.Movie
import com.movieapp.MovieApp.model.MovieRatingRequest
import com.movieapp.MovieApp.service.UserActionService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rateMovie")
class RateMovieController(
    private val service: UserActionService
) {

    @PostMapping
    fun rateMovie(@RequestBody userRatingRequest: MovieRatingRequest): Movie {
        return service.rateMovie(userRatingRequest)
    }

}