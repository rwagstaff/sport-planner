package rw.user

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.{Before, Test}
import org.assertj.core.api.{Assert, Assertions}
import org.springframework.boot.test.json.JacksonTester

class UserTest {
  val json: JacksonTester[User] = null
  val user = new User("a name", "an email")


  @Before
  def setUp() {
    val ojm = new ObjectMapper()
    JacksonTester.initFields(this, ojm)

  }

  @Test
  def shouldWriteAndReadJSON() {
    val expectedJson: String = "{\"name\":\"a name\",\"email\":\"an email\",\"id\": 0}"
    Assertions.assertThat(this.json.write(user)).isEqualToJson(expectedJson)
  }


}