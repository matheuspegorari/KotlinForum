package dev.pegorari.forum.repository

import dev.pegorari.forum.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}