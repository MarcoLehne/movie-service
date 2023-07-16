package com.movieapp.MovieApp.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.movieapp.MovieApp.model.Movie
import com.movieapp.MovieApp.model.MovieRatingRequest
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
class RateMovieControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper
) {

    @Test
    fun `should rate a movie`() {

        val movieRatingRequest = MovieRatingRequest(
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
            ),
            rating = 4
        )


        val performPostRequest = mockMvc.post("/rateMovie") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(movieRatingRequest)
        }

        performPostRequest.andExpect {
            status { isOk() }
            content { contentType(MediaType.APPLICATION_JSON)}
            jsonPath(".title") { value("Raiders of the Lost Ark")}
            jsonPath(".rating") { value(4.0) }
            jsonPath(".amountOfRatings") { value(1) }
        }
    }
}