package beeline.restapi

import com.softwaremill.sttp.{HttpURLConnectionBackend, _}
import org.scalatest.{Matchers, WordSpec}

class ApplicationTest extends WordSpec with Matchers{
    "Service" should {
      "response on target port" in {
        implicit val backend = HttpURLConnectionBackend()
        Application.start()
        sttp.get(uri"http://localhost:8001/").send().code shouldBe 200
      }
    }
}
