package dev.pegorari.forum.service

import dev.pegorari.forum.model.Course
import dev.pegorari.forum.model.Post
import dev.pegorari.forum.model.User
import org.springframework.stereotype.Service

@Service
class PostService {
    fun listPosts(): List<Post> {
        val post = Post(
            id = 1,
            title = "Hello",
            message = "Kotlin",
            author = User(
                id = 1,
                name = "Matheus",
                email = "pegorari@gmail.com"
            ),
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programming Language"
            )
        )

        return listOf(post, post, post)
    }

}