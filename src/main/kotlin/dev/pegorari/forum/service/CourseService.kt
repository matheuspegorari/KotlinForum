package dev.pegorari.forum.service

import dev.pegorari.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(private var courses: List<Course>) {
    init {
        val course = Course(1, "Kotlin", "Languages")
        this.courses = listOf(course)
    }

    fun findById(id: Long): Course {
        return courses.find { it.id == id }!!
    }
}
