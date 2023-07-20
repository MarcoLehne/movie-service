package com.movieapp.MovieApp.config

import com.movieapp.MovieApp.security.CustomPasswordEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class PasswordEncoderConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return CustomPasswordEncoder()
    }
}