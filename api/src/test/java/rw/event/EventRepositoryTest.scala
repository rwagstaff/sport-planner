package rw.event

import java.time.LocalDateTime

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import rw.db.AbstractRepositoryTest

class EventRepositoryTest extends AbstractRepositoryTest[Event] {
  @Autowired val repo: EventRepository = null

  override protected def instance: Event = {
    new Event("new event", LocalDateTime.now())
  }

  override protected def getRepository: JpaRepository[Event, Integer] = {
    repo
  }

  override protected def update(instance: Event): Unit = {
    instance.name = "another event"
  }
}