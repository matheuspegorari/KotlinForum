package dev.pegorari.forum.service

import dev.pegorari.forum.exception.NotFoundException
import dev.pegorari.forum.model.User
import dev.pegorari.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {

    fun findById(id: Long): User {
        return repository.findById(id).orElseThrow {
            NotFoundException("User with ID $id not found")
        }
    }
}