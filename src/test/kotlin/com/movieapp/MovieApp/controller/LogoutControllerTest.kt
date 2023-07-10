package com.movieapp.MovieApp.controller

import com.fasterxml.jackson.databind.ObjectMapper
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
class LogoutControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {

    @Test
    fun `should log user out`() {

        val userToken = UserToken(
            "stargazer74",
            "1"
        )

        val performPostRequest = mockMvc.post("/logout") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(userToken)
        }

        performPostRequest
            .andExpect {
                status { isOk() }
                content { contentType( MediaType.APPLICATION_JSON )}
                jsonPath(".message") { value("userIsLoggedOut")}

            }
    }
}