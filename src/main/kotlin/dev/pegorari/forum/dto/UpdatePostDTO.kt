package dev.pegorari.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class UpdatePostDTO(
    @field:Size(min = 5, max = 100)
    val title: String,
    @field:NotEmpty
    val message: String
) {

}
