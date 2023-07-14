package com.movieapp.MovieApp.datasource.mock

import com.movieapp.MovieApp.datasource.MovieDataSource
import com.movieapp.MovieApp.model.Movie
import org.springframework.stereotype.Repository

@Repository
class MockMovieDataSource : MovieDataSource {

    val movies = mutableListOf(
        Movie(
            "Raiders of the Lost Ark",
            "06-12-81",
            "Steven Spielberg",
            null,
            0
        ),
        Movie(
            "Harry Potter and the Philosopher's Stone",
            "11-22-2001",
            "Chris Columbus",
            5.0,
            1
        ),
        Movie(
            "2001: A Space Odyssey",
            "04-02-1968",
            "Stanley Kubrick",
            null,
            0
        )
    )

    override fun retrieveMovies(): Collection<Movie> {
        return movies
    }

    override fun retrieveMovie(movie: Movie): Movie? {
        return movies.find { it.title == movie.title }
    }

    override fun createMovie(movie: Movie): Movie {
        movies.add(movie)
        return movie
    }
}