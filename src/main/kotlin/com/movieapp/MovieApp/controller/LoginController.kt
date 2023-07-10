package com.movieapp.MovieApp.controller

import com.movieapp.MovieApp.model.UserLoginRequest
import com.movieapp.MovieApp.model.UserToken
import com.movieapp.MovieApp.service.UserStateService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController(private val service: UserStateService) {

    @PostMapping
    @ResponseBody
    fun loginUser(@RequestBody userLoginRequest: UserLoginRequest): ResponseEntity<UserToken> {

        val userToken = service.loginUser(userLoginRequest)

        println(userToken)

        return if (userToken != null) {
            ResponseEntity.ok(userToken)
        } else ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
    }

}