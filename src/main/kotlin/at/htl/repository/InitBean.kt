package at.htl.repository

import at.htl.entity.Person
import at.htl.entity.Status
import at.htl.repository.PersonRepository
import io.quarkus.runtime.StartupEvent
import java.time.LocalDate
import java.time.Month
import javax.enterprise.event.Observes
import javax.inject.Inject
import javax.transaction.Transactional

class InitBean {

    @Inject
    lateinit var personRepository: PersonRepository

    @Transactional
    fun init(@Observes event: StartupEvent){
        // delete all people
        personRepository.deleteAll()

        // creating a normal person
        var person = Person()
        person.name = "Steve"
        person.birth = LocalDate.of(1980, Month.FEBRUARY, 1)
        person.status = Status.ALIVE

        personRepository.persist(person)

        // create an over 1000 y/o person which is alive
        var person2 = Person()
        person2.name = "Bill"
        person2.birth = LocalDate.of(1003, Month.JANUARY, 5)
        person2.status = Status.ALIVE

        personRepository.persist(person2)

        // correct the person and declare him dead
        personRepository.update("status = ?1 where name = 'Bill'", Status.DEAD)
    }
}