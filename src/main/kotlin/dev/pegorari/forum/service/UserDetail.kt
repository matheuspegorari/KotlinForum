package dev.pegorari.forum.service

import dev.pegorari.forum.model.Users
import org.springframework.security.core.userdetails.UserDetails

class UserDetail (private val user : Users) : UserDetails {
    override fun getAuthorities() = null

    override fun getPassword() = user.password

    override fun getUsername() = user.email
}