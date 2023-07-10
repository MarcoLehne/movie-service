package com.movieapp.MovieApp.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.movieapp.MovieApp.model.Movie
import com.movieapp.MovieApp.model.MovieCreateRequest
import com.movieapp.MovieApp.model.UserLoginRequest
import com.movieapp.MovieApp.model.UserToken
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
class LoginControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {
    @Test
    fun `should log user in`() {

        val userLoginRequest = UserLoginRequest(
                "twistingShadow1",
                "555ju5"
        )

        val performPostRequest = mockMvc.post("/login") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(userLoginRequest)
        }

        performPostRequest
            .andExpect {
                status { isOk() }
                content { contentType( MediaType.APPLICATION_JSON ) }
                jsonPath(".userName") { value("twistingShadow1") }
                jsonPath(".token") { value( "1" ) }
            }
    }
}