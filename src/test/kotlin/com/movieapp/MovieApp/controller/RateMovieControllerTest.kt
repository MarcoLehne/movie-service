//package com.movieapp.MovieApp.controller
//
//import com.fasterxml.jackson.databind.ObjectMapper
//import com.movieapp.MovieApp.model.Movie
//import com.movieapp.MovieApp.model.MovieRatingRequest
//import org.junit.jupiter.api.Assertions
//import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.http.MediaType
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.patch
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class RateMovieControllerTest @Autowired constructor(
//    val mockMvc: MockMvc,
//    val objectMapper: ObjectMapper
//) {
//
//    @Test
//    fun `should return updated movie after rating`() {
//
//        val movieRatingRequest = MovieRatingRequest(
//            movie = Movie("2001: A Space Odyssey",
//                "04-02-1968",
//                "Stanley Kubrick",
//                null,
//                0
//            ),
//            rating = 5
//        )
//
//        val performPatchRequest = mockMvc.patch("/rate") {
//            contentType = MediaType.APPLICATION_JSON
//            content = objectMapper.writeValueAsString(movieRatingRequest)
//        }
//
//        performPatchRequest
//            .andExpect {
//                status { isOk() }
//                content { contentType(MediaType.APPLICATION_JSON) }
//                jsonPath("$.rating") { value("5.0")}
//                jsonPath("$.amountOfRatings") { value("1")}
//            }
//    }
//}