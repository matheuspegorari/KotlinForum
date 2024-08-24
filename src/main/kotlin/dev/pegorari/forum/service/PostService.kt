package dev.pegorari.forum.service

import dev.pegorari.forum.dto.RequestPostDTO
import dev.pegorari.forum.model.Post
import org.springframework.stereotype.Service

@Service
class PostService(
    private var posts: List<Post> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService
) {
    fun listPosts(): List<Post> {
        return this.posts
    }

    fun findByID(id: Long): Post? {
        return this.posts.find { it.id == id }
    }

    fun create(dto: RequestPostDTO) {
        posts = posts.plus(
            Post(
                id = (this.posts.size + 1).toLong(),
                title = dto.title,
                message = dto.message,
                course = courseService.findById(dto.courseId),
                author = userService.findById(dto.authorId)
            )
        )
    }

}