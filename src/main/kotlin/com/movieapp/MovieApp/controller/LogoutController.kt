package com.movieapp.MovieApp.controller

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
@RequestMapping("/logout")
class LogoutController(private val service: UserStateService) {

    @PostMapping
    @ResponseBody
    fun logoutUser(@RequestBody userToken: UserToken): ResponseEntity<Map<String,String> > {

        val userToken = service.logoutUser(userToken)

        return if (userToken != null) {
            ResponseEntity.ok(mapOf("message" to "userIsLoggedOut"))
        } else ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
    }
}