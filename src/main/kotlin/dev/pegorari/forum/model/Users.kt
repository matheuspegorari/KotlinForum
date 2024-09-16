package dev.pegorari.forum.model

import jakarta.persistence.*


@Entity
@Table(name = "users")
data class Users(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val email: String,
    val password : String,


    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "users_role",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "role_id", referencedColumnName = "id")])
    val role: List<Role> = mutableListOf()
) {
}
