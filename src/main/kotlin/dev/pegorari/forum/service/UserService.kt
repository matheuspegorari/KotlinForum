package dev.pegorari.forum.service

import dev.pegorari.forum.exception.NotFoundException
import dev.pegorari.forum.model.Users
import dev.pegorari.forum.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) : UserDetailsService {

    fun findById(id: Long): Users {
        return repository.findById(id).orElseThrow {
            NotFoundException("User with ID $id not found")
        }
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = repository.findByEmail(username)
            ?: throw NotFoundException("User $username not found")
        return UserDetail(user)
    }
}