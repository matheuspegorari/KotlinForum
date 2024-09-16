package dev.pegorari.forum.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority

@Entity
@Table(name = "role")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    val name: String,
    @JsonIgnore
    @ManyToMany(mappedBy = "role", fetch = FetchType.EAGER) val users: Set<Users>
) : GrantedAuthority {

    override fun getAuthority() = "ROLE_$name"
}
