package rw.data

import javax.annotation.PostConstruct

import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.{Component, Service}
import rw.user.{User, UserService}

/**
  * I create some test data depending on the profile
  */
@Service
class InitialiseData extends LazyLogging{

  @Autowired val service: UserService = null

  @PostConstruct
  def createData(): Unit = {
    service.save(new User("Admin", "somewhere@someplace.com"))
    service.save(new User("Richard", "somewhere@someplace1.com"))
    logger.info("Created test data")
  }


}
