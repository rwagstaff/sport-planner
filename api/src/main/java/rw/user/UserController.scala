package rw.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

@RestController
class UserController {

  @Autowired val service: UserService = null

  @RequestMapping(path = Array("user/{id}"), method = Array(RequestMethod.GET))
  def findUser(@PathVariable("id") id: Int): User = {
    service.findUser(id)
  }

  @RequestMapping(path = Array("users"), method = Array(RequestMethod.GET))
  def findUsers(): java.util.List[User] = {
    service.findAll()
  }

  @RequestMapping(path = Array("user"), method = Array(RequestMethod.POST))
  def saveDates(@RequestBody user: User): Int = {
    service.save(user)
  }


}
