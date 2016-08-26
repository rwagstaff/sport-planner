package rw.event

import org.junit.runner.RunWith
import org.junit.{Ignore, Test}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import rw.db.AbstractRepositoryTest
import rw.friend.FriendRepository

class EventRepositoryTest extends AbstractRepositoryTest[Event] {
  @Autowired val repo: EventRepository = null

  override protected def instance: Event = {
    new Event("new event")
  }

  override protected def getRepository: JpaRepository[Event, Integer] = {
    repo
  }

  override protected def update(instance: Event): Unit = {
    instance.name = "another event"
  }
}