package dev.pegorari.forum.repository

import dev.pegorari.forum.model.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Course, Long> {
}