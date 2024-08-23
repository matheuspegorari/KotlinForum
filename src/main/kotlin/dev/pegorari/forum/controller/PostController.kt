package dev.pegorari.forum.controller

import dev.pegorari.forum.model.Course
import dev.pegorari.forum.model.Post
import dev.pegorari.forum.model.User
import dev.pegorari.forum.service.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/posts")
class PostController (private val service: PostService) {

    @GetMapping
    fun listPosts(): List<Post> {
        return service.listPosts()
    }


}