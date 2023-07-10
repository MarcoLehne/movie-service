package com.movieapp.MovieApp.controller

import com.movieapp.MovieApp.model.Movie
import com.movieapp.MovieApp.service.MovieService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movies")
class GetMoviesController(private val service: MovieService) {

    @GetMapping
    fun retrieveMovies(): Collection<Movie> {
        return service.retrieveMovies()
    }
}