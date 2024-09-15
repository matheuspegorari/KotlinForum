package dev.pegorari.forum.dto.query

data class PostByCategory (
    val category : String,
    val count: Long
)