package dev.pegorari.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class RequestPostDTO(
    @field:Size(min = 5, max = 100, message = "Must be min 5 and max 100")
    val title: String,
    @field:NotEmpty val message: String,
    @field:NotNull val courseId: Long,
    @field:NotNull val authorId: Long
) {

}
