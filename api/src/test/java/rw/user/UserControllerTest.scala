package rw.user

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner
import rw.test.AbstractControllerTest
import collection.JavaConversions._

@RunWith(classOf[SpringRunner])
class UserControllerTest extends AbstractControllerTest {

  val user = new User("a name", "someemail@somewhere.com")

  @Test
  def shouldCreateAndFindUser() {
    val response: ResponseEntity[Int] = getTemplate.postForEntity("/user", user, classOf[Int], classOf[User])
    assert(response.getStatusCode.is2xxSuccessful())
    val id: Int = response.getBody
    assert(id > 0)
    val params = mapAsJavaMap(Map("id" -> id))

    val userResponse : ResponseEntity[User] = getTemplate.getForEntity("/user/{id}", classOf[User], params)
    assert(userResponse.getStatusCode.is2xxSuccessful())
  }


}