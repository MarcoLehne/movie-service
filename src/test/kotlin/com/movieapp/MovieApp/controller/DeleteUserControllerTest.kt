package com.movieapp.MovieApp.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.movieapp.MovieApp.model.UserDeleteRequest
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
class DeleteUserControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {

    @Test
    fun `should delete user`() {

        val userDeleteRequest = UserDeleteRequest(
            "stargazer74",
            "jju23"
        )

        val performPostRequest = mockMvc.post("/deleteUser") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(userDeleteRequest)
        }

        performPostRequest
            .andExpect {
                status { isOk() }
                content { contentType( MediaType.APPLICATION_JSON)}
                jsonPath(".message") { value("userWasDeleted")}
            }
    }
}