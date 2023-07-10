//package com.movieapp.MovieApp.controller
//
//import com.movieapp.MovieApp.model.Movie
//import com.movieapp.MovieApp.model.MovieRatingRequest
//import com.movieapp.MovieApp.service.MovieService
//import org.springframework.web.bind.annotation.PatchMapping
//import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//@RequestMapping("/rate")
//class RateMovieController(private val service: MovieService) {
//
//    @PatchMapping
//    fun rateMovie(@RequestBody movieRatingRequest: MovieRatingRequest): Movie {
//        return service.rateMovie(movieRatingRequest)
//    }
//}