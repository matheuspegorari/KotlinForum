package dev.pegorari.forum.service

import dev.pegorari.forum.dto.RequestPostDTO
import dev.pegorari.forum.dto.ResponsePostDTO
import dev.pegorari.forum.dto.UpdatePostDTO
import dev.pegorari.forum.mapper.RequestPostMapper
import dev.pegorari.forum.mapper.ResponsePostMapper
import dev.pegorari.forum.model.Post
import org.springframework.stereotype.Service

@Service
class PostService(
    private var posts: List<Post> = ArrayList(),
    private val requestPostMapper: RequestPostMapper,
    private val responsePostMapper: ResponsePostMapper

) {
    fun listPosts(): List<ResponsePostDTO>? {
        return this.posts.map { p ->
            responsePostMapper.map(p)
        }
    }

    fun findByID(id: Long): ResponsePostDTO? {
        val post = getPostById(id) ?: return null

        return responsePostMapper.map(post)
    }


    fun create(dto: RequestPostDTO) {
        val newPost = requestPostMapper.map(dto)
        newPost.id = posts.size.toLong() + 1

        posts = posts.plus(newPost)
    }

    fun update(id: Long, dto: UpdatePostDTO) {
        val post = getPostById(id) ?: return

        post.title = dto.title
        post.message = dto.message

    }

    fun delete(id: Long) {
        val post = this.posts.find { it.id == id } ?: return
        this.posts.minus(post)

    }

    private fun getPostById(id: Long): Post? {
        val post = this.posts.find { it.id == id } ?: return null
        return post
    }



}