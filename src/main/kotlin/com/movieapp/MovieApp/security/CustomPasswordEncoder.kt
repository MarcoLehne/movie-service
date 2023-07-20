package com.movieapp.MovieApp.security

import org.springframework.security.crypto.password.PasswordEncoder

class CustomPasswordEncoder: PasswordEncoder {

    private val fixedSalt = "fixed_salt_for_testing"
    override fun encode(rawPassword: CharSequence?): String {
        return (rawPassword.toString() + fixedSalt).reversed()
    }

    override fun matches(rawPassword: CharSequence?, encodedPassword: String?): Boolean {
        return (rawPassword.toString() + fixedSalt).reversed() == encodedPassword
    }
}