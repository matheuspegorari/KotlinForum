package dev.pegorari.forum.controller

import dev.pegorari.forum.dto.RequestPostDTO
import dev.pegorari.forum.dto.ResponsePostDTO
import dev.pegorari.forum.service.PostService
import org.springframework.web.bind.annotation.*

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
    fun create(@RequestBody dto: RequestPostDTO) {
        service.create(dto)
    }


}