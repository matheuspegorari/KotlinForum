package dev.pegorari.forum.mapper

import dev.pegorari.forum.dto.ResponsePostDTO
import dev.pegorari.forum.model.Post
import org.springframework.stereotype.Component

@Component
class ResponsePostMapper : Mapper<Post, ResponsePostDTO> {
    override fun map(t: Post): ResponsePostDTO {
        return ResponsePostDTO(t.id, t.title, t.message, t.status, t.createdAt)
    }
}