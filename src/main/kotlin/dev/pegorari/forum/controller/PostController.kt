package dev.pegorari.forum.controller

import dev.pegorari.forum.dto.RequestPostDTO
import dev.pegorari.forum.dto.ResponsePostDTO
import dev.pegorari.forum.dto.UpdatePostDTO
import dev.pegorari.forum.service.PostService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/posts")
class PostController(private val service: PostService) {

    @GetMapping
    fun allPosts(
        @RequestParam(required = false) courseName: String?,
        @PageableDefault(size = 5, sort = ["createdAt"], direction = Sort.Direction.DESC)
        pagination: Pageable
    ): Page<ResponsePostDTO>? {
        return service.listPosts(courseName, pagination)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponsePostDTO? {
        return service.findByID(id)
    }

    @PostMapping
    @Transactional
    fun create(
        @RequestBody @Valid dto: RequestPostDTO, uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ResponsePostDTO> {
        val newPost = service.create(dto)
        val uri = uriBuilder.path("/posts/${newPost.id}").build().toUri()
        return ResponseEntity.created(uri).body(newPost)

    }

    @PutMapping("/{id}")
    @Transactional
    fun update(
        @PathVariable id: Long,
        @RequestBody @Valid dto: UpdatePostDTO
    ): ResponseEntity<ResponsePostDTO> {
        val updatedPost = service.update(id, dto)
        return ResponseEntity.ok(updatedPost)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}