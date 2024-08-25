package dev.pegorari.forum.mapper

import dev.pegorari.forum.dto.RequestPostDTO
import dev.pegorari.forum.model.Post
import dev.pegorari.forum.service.CourseService
import dev.pegorari.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class RequestPostMapper(
    private val courseService: CourseService,
    private val userService: UserService
) : Mapper<RequestPostDTO, Post> {
    override fun map(t: RequestPostDTO): Post {
        return Post(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.courseId),
            author = userService.findById(t.authorId)
        )
    }

}
