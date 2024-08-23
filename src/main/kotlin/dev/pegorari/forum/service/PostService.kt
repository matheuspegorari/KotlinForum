package dev.pegorari.forum.service

import dev.pegorari.forum.model.Course
import dev.pegorari.forum.model.Post
import dev.pegorari.forum.model.User
import org.springframework.stereotype.Service

@Service
class PostService(private var posts: List<Post>) {
    fun listPosts(): List<Post> {
        return this.posts
    }

    fun findByID(id: Long): Post? {
        return this.posts.find { it.id == id }
    }

    init {
        val kotlinCourse = Course(
            id = 1, name = "Kotlin", category = "Programming Language"
        )
        val post = Post(
            id = 1,
            title = "Campo Calculado - Construtor de Telas",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            author = User(
                id = 1, name = "Emerson", email = "emerson@gmail.com"
            ),
            course = kotlinCourse

        )

        val post2 = Post(
            id = 2,
            title = "Rastreabilidade Renegociações",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            author = User(
                id = 2, name = "Eduardo", email = "eduardo@gmail.com"
            ),
            course = kotlinCourse
        )

        val post3 = Post(
            id = 3,
            title = "Mostrar imagem do produto pela api apresenta erro no servidor",
            message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            author = User(
                id = 3, name = "João", email = "joao@gmail.com"
            ),
            course = kotlinCourse
        )

        this.posts = listOf(post, post2, post3)
    }
}