package com.movieapp.MovieApp.service

import com.movieapp.MovieApp.datasource.MovieDataSource
import com.movieapp.MovieApp.model.Movie
import org.springframework.stereotype.Service

@Service
class MovieService(private val dataSource: MovieDataSource) {

    fun retrieveMovies(): Collection<Movie> {
        return dataSource.retrieveMovies()
    }

    fun retrieveMovie(movie: Movie): Movie? {
        return dataSource.retrieveMovie(movie)
    }

    fun createMovie(movie: Movie): Movie {
        return dataSource.createMovie(movie)
    }
}