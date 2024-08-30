package dev.pegorari.forum.model

import dev.pegorari.forum.enums.PostStatus
import jakarta.persistence.*
import java.time.Instant

@Entity
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    var message: String,
    val createdAt: Instant = Instant.now(),
    @ManyToOne
    val course: Course,
    @ManyToOne
    val author: User,
    @Enumerated(EnumType.STRING)
    var status: PostStatus = PostStatus.NO_ANSWER,
    @OneToMany(mappedBy = "post")
    val responses: List<Response> = ArrayList()


)