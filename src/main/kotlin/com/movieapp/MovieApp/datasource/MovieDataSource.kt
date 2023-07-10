package com.movieapp.MovieApp.datasource

import com.movieapp.MovieApp.model.Movie

interface MovieDataSource {
    fun retrieveMovies(): Collection<Movie>
    fun retrieveMovie(movie: Movie): Movie?
    fun createMovie(movie: Movie): Movie
}