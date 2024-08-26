package dev.pegorari.forum.dto

import java.time.Instant

data class ErrorDTO(
    val timestamp: Instant = Instant.now(),
    val status: Int,
    val error : String,
    val message: String?,
    val path : String
) {


}
