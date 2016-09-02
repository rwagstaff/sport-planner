package rw.test


import java.net.{InetSocketAddress, Proxy}

import com.typesafe.scalalogging.LazyLogging
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.client.SimpleClientHttpRequestFactory

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
abstract class AbstractControllerTest extends LazyLogging{

  @Autowired var template: TestRestTemplate = _
  val proxyHost: String = "localhost"
  val proxyPort: Int = 8888

  @Value("${rest.proxy}")
  var proxy: Boolean = _

  def getTemplate: TestRestTemplate = {
    if (proxy) {
      logger.warn(s"Using proxy on host $proxyHost:$proxyHost")
      template.getRestTemplate.setRequestFactory(getFactory)
    }
    template
  }

  def getFactory = {
    val requestFactory: SimpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory()
    // Proxy via web fiddler, this will allow you to record/replay rest request
    val fiddler: Proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort))
    requestFactory.setProxy(fiddler)
    requestFactory
  }


}