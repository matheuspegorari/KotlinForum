package dev.pegorari.forum.model

import dev.pegorari.forum.enums.PostStatus
import java.time.Instant

data class Post(
    var id: Long? = null,
    var title: String,
    var message: String,
    val createdAt: Instant = Instant.now(),
    val course: Course,
    val author: User,
    var status: PostStatus = PostStatus.NO_ANSWER,
    val responses: List<Response> = ArrayList()


)