package study.querydsl_kotlin.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Hello(
    @Id
    @GeneratedValue
    var id: Long? = null
) {
}