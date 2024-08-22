package dev.pegorari.forum.model

import dev.pegorari.forum.enums.PostStatus
import java.time.LocalDateTime

data class Post(
    val id: Long? = null,
    val title: String,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: PostStatus = PostStatus.NO_ANSWER,
    val responses : List<Response> = ArrayList()
) {
}