package com.movieapp.MovieApp.controller

import com.movieapp.MovieApp.model.User
import com.movieapp.MovieApp.service.UserDataService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/createUser")
class CreateUserController(
    private val service: UserDataService
) {

    @PostMapping
    fun createUser(@RequestBody user: User): User? {
        return service.createUser(user)
    }
}