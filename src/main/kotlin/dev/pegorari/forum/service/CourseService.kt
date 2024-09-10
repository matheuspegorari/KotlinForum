package dev.pegorari.forum.service

import dev.pegorari.forum.exception.NotFoundException
import dev.pegorari.forum.model.Course
import dev.pegorari.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private var repository: CourseRepository) {


    fun findById(id: Long): Course {
        return repository.findById(id).orElseThrow{
            NotFoundException("Course with ID $id not found")
        }
    }
}
