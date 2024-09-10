package dev.pegorari.forum.infra

import dev.pegorari.forum.model.Course
import dev.pegorari.forum.model.User
import dev.pegorari.forum.repository.CourseRepository
import dev.pegorari.forum.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DatabaseInitializer(
    private val cRepository: CourseRepository,
    private val uRepository: UserRepository,
    @Value("\${TEST_MODE:false}") private val testMode: String
) : CommandLineRunner {

    @Transactional
    override fun run(vararg args: String?) {
        if (testMode == "true") {
            if (cRepository.count() == 0L) {
                val cEntity = Course(1, "Kotlin", "PROGRAMAÇÃO")
                cRepository.save(cEntity)
                println("TEST_DATA: Course data inserted as TEST_MODE is true")
            }
            if (uRepository.count() == 0L) {
                val uEntity = User(1, "Matheus", "pegorari@gmail.com")
                uRepository.save(uEntity)
                println("TEST_DATA: User data inserted as TEST_MODE is true")
            }
        } else {
            println("TEST_DATA: Skipping data insert as TEST_MODE is not 'true'")
        }
    }
}