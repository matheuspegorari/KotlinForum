package dev.pegorari.forum.dto

data class RequestPostDTO(
    val title: String,
    val message: String,
    val courseId: Long,
    val authorId: Long
){

}
