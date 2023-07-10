package com.movieapp.MovieApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MovieAppApplication

fun main(args: Array<String>) {
	runApplication<MovieAppApplication>(*args)
}
