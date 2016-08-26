package rw.friend

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import rw.db.AbstractRepositoryTest

class FriendRepositoryTest extends AbstractRepositoryTest[Friend] {
  @Autowired val repo: FriendRepository = null

  override protected def instance: Friend = {
    new Friend("some guy")
  }


  override protected def getRepository: JpaRepository[Friend, Integer] = {
    repo
  }

  override protected def update(instance: Friend) = {
    instance.name = "a new friend"
  }
}