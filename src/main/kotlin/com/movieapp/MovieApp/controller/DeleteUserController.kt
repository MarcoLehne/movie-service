package com.movieapp.MovieApp.controller

import com.movieapp.MovieApp.model.UserDeleteRequest
import com.movieapp.MovieApp.service.UserDataService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/deleteUser")
class DeleteUserController(
    private val service: UserDataService
) {

    @PostMapping
    fun deleteUser(@RequestBody userDeleteRequest: UserDeleteRequest): ResponseEntity<Map<String, String>> {
        return ResponseEntity.ok(mapOf("message" to "userWasDeleted"))
    }

}