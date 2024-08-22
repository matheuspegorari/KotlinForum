package dev.pegorari.forum.model

import java.time.LocalDateTime

data class Response(
    val id: Long? = null,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val post: Post,
    val solution: Boolean
) {

}
