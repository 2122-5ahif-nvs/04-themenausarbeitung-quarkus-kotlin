package at.htl.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

enum class Status{
    ALIVE, DEAD
}

@Entity
class Person {
    @Id
    @GeneratedValue
    var id: Long? = null;
    lateinit var name: String
    lateinit var birth: LocalDate
    lateinit var status: Status
}