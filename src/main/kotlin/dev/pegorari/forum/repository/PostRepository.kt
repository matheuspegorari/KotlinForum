package dev.pegorari.forum.repository

import dev.pegorari.forum.dto.query.PostByCategory
import dev.pegorari.forum.model.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PostRepository : JpaRepository<Post, Long> {
    fun findByCourseName(courseName: String, pagination: Pageable): Page<Post>

    @Query(
        "SELECT new dev.pegorari.forum.dto.query.PostByCategory(course.category, count(p)) " +
                "FROM Post p " +
                "JOIN p.course course " +
                "GROUP BY course.category"
    )
    fun report(): List<PostByCategory>
}