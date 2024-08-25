package dev.pegorari.forum.dto

import dev.pegorari.forum.enums.PostStatus
import java.time.Instant

data class ResponsePostDTO(
    val id: Long?,
    val title: String,
    val message: String,
    val status: PostStatus,
    val createdAt: Instant
){

}
