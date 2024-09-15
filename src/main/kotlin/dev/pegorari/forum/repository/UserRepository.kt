package dev.pegorari.forum.repository

import dev.pegorari.forum.model.Users
import org.springframework.data.jpa.repository.JpaRepository


interface UserRepository : JpaRepository<Users, Long> {
    fun findByEmail(courseName: String?): Users?
}