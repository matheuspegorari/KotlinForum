package dev.pegorari.forum.service

import dev.pegorari.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(private var users: List<User>) {
    init {
        val user = User(1, "Matheus", "pegorari@gmail.com")
        this.users = listOf(user)
    }

    fun findById(id: Long): User {
        return users.find { it.id == id }!!
    }
}