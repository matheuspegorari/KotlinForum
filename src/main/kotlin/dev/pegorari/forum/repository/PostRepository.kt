package dev.pegorari.forum.repository

import dev.pegorari.forum.model.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun findByCourseName(courseName: String, pagination : Pageable): Page<Post>
}