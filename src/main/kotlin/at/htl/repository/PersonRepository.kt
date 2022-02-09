package at.htl.repository

import at.htl.entity.Person
import at.htl.entity.Status
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonRepository : PanacheRepository<Person> {
    fun findByName(name: String) = find("name", name).firstResult()
    fun findAlive() = list("status", Status.ALIVE)
}