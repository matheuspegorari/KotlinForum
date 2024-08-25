package dev.pegorari.forum.controller

import dev.pegorari.forum.dto.RequestPostDTO
import dev.pegorari.forum.dto.ResponsePostDTO
import dev.pegorari.forum.dto.UpdatePostDTO
import dev.pegorari.forum.service.PostService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/posts")
class PostController(private val service: PostService) {

    @GetMapping
    fun listPosts(): List<ResponsePostDTO>? {
        return service.listPosts()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponsePostDTO? {
        return service.findByID(id)
    }

    @PostMapping
    fun create(
        @RequestBody @Valid dto: RequestPostDTO,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ResponsePostDTO> {
        val newPost = service.create(dto)
        val uri = uriBuilder.path("/posts/${newPost.id}").build().toUri()
        return ResponseEntity.created(uri).body(newPost)

    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid dto: UpdatePostDTO)
    : ResponseEntity<ResponsePostDTO> {
        val updatedPost = service.update(id, dto)
        return ResponseEntity.ok(updatedPost)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }
}