package dev.pegorari.forum.repository

import dev.pegorari.forum.model.Post
import org.springframework.data.repository.CrudRepository

interface PostRepository:CrudRepository <Post, Long> {
}