package com.movieapp.MovieApp.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.movieapp.MovieApp.model.Movie
import com.movieapp.MovieApp.model.MovieCreateRequest
import com.movieapp.MovieApp.model.UserToken
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class CreateMovieControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {
    @Test
    fun `should return new movie upon successful creation`() {

        val newMovie = MovieCreateRequest(
            Movie(
                "Iron Man",
                "5-1-2008",
                "Jon Favreau",
                null,
                0
            ),
            UserToken(
                "stargazer74",
                "1"
            )
        )

        val performPostRequest = mockMvc.post("/createMovie") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newMovie)
        }

        performPostRequest
            .andExpect {
                status { isOk() }
                content { contentType( MediaType.APPLICATION_JSON ) }
                jsonPath("$.title") { value("Iron Man")}
            }
    }
}