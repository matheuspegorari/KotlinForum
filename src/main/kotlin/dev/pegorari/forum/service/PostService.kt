package dev.pegorari.forum.service

import dev.pegorari.forum.dto.RequestPostDTO
import dev.pegorari.forum.dto.ResponsePostDTO
import dev.pegorari.forum.dto.UpdatePostDTO
import dev.pegorari.forum.dto.query.PostByCategory
import dev.pegorari.forum.exception.NotFoundException
import dev.pegorari.forum.mapper.RequestPostMapper
import dev.pegorari.forum.mapper.ResponsePostMapper
import dev.pegorari.forum.model.Post
import dev.pegorari.forum.repository.PostRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PostService(
    private var repository: PostRepository,
    private val requestPostMapper: RequestPostMapper,
    private val responsePostMapper: ResponsePostMapper

) {
    fun listPosts(courseName: String?, pagination: Pageable): Page<ResponsePostDTO>? {
        val posts = when {
            courseName.isNullOrBlank() -> repository.findAll(pagination)
            else -> repository.findByCourseName(courseName, pagination)
        }

        return posts.map(responsePostMapper::map)
    }

    fun findByID(id: Long): ResponsePostDTO? {
        val post = getPostById(id)
        return responsePostMapper.map(post)
    }


    fun create(dto: RequestPostDTO): ResponsePostDTO {
        val newPost = requestPostMapper.map(dto)
        repository.save(newPost)
        return responsePostMapper.map(newPost)
    }

    fun update(id: Long, dto: UpdatePostDTO): ResponsePostDTO? {
        val post = getPostById(id)
        post.title = dto.title
        post.message = dto.message

        return responsePostMapper.map(post)
    }

    fun delete(id: Long) {
        repository.deleteById(id)
    }

    private fun getPostById(id: Long): Post {
        val post = repository.findById(id).orElseThrow {
            NotFoundException("Post with ID $id not found")
        }
        return post
    }

    fun report(): List<PostByCategory> {
        return repository.report()
    }
}