package rw.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import rw.db.AbstractRepositoryTest
import rw.friend.{Friend, FriendTest}


class UserRepositoryTest extends AbstractRepositoryTest[User] {
  @Autowired val repo: UserRepository = null

  override protected def instance: User = {
    val user = new User("A guy", "someemail@somewhere.com")
    val friends: List[Friend] = FriendTest.testFriends(user)
    user.setFriends(friends)
    user
  }


  override protected def getRepository: JpaRepository[User, Integer] = {
    repo
  }

  override protected def update(instance: User) = {
    instance.name = "a new user"
  }
}