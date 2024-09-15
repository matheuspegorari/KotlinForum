package dev.pegorari.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Response(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val message: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val author: Users,
    @ManyToOne
    val post: Post,
    val solution: Boolean
) {

}
