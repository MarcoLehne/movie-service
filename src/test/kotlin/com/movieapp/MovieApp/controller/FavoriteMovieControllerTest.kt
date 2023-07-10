package com.movieapp.MovieApp.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.movieapp.MovieApp.model.Movie
import com.movieapp.MovieApp.model.MovieFavoriteRequest
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
class FavoriteMovieControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {

    @Test
    fun `should favorite a movie`() {
        val movieFavoriteRequest = MovieFavoriteRequest(
            Movie(
                "Raiders of the Lost Ark",
                "06-12-81",
                "Steven Spielberg",
                null,
                0
            ),
            UserToken(
                "stargazer74",
                "1"
            )
        )

        val performPostRequest = mockMvc.post("/favoriteMovie") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(movieFavoriteRequest)
        }

        performPostRequest
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath(".title") { value("Raiders of the Lost Ark")}
            }
    }
}