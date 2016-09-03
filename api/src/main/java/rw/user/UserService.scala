package rw.user

import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService extends LazyLogging{

  @Autowired val repo: UserRepository = null

  def findUser(id: Int): User = {
    val u = repo.findOne(id)
    logger.debug(s"Found user $u for id $id")
    u
  }

  def save(user: User): Int = {
    repo.save(user)
    repo.flush()
    logger.debug(s"Saved user with id $user.id")
    user.id
  }

}
