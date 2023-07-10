package com.movieapp.MovieApp.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.movieapp.MovieApp.model.User
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class CreateUserControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {

    @Test
    fun `should create new user`() {

        val newUser = User(
            "amigo24",
            "jhjhjh234",
            favoriteMovies = mutableListOf(),
            ratedMovies = mutableListOf()
        )

        val performPostRequest = mockMvc.post("/createUser") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newUser)
        }

        performPostRequest
            .andExpect {
                status { isOk() }
                content { contentType (MediaType.APPLICATION_JSON)}
                jsonPath(".userName") { value("amigo24")}
            }
    }
}