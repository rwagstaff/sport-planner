package rw.user

import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired

object UserService  extends LazyLogging{

  @Autowired val repo: UserRepository = null

  def findUser(id: Int): Unit = {
    val u = repo.findOne(id)
    logger.debug(s"Found user $u for id $id")
  }


}
