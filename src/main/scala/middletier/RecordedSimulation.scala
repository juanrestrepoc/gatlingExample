package middletier

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8001")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.8,es;q=0.6")
		.contentTypeHeader("application/json")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36")

	val headers_0 = Map(
		"Accept-Encoding" -> "gzip, deflate, sdch",
		"Postman-Token" -> "6de12df1-993a-0e2e-b303-0e7af59483f7")

	val headers_1 = Map(
		"Origin" -> "chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop",
		"Postman-Token" -> "750a251f-3b72-4994-eb28-aaac4cf6d72c")

	val headers_2 = Map(
		"Origin" -> "chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop",
		"Postman-Token" -> "2633381a-af52-1df6-fef0-e0d76ee92b1c")

	val headers_3 = Map(
		"Accept-Encoding" -> "gzip, deflate, sdch",
		"Postman-Token" -> "072c2917-3fa9-c915-45ca-4a4c9224057e")

    val uri1 = "http://localhost:8001/v1/pokemons"

	val scn = scenario("RecordedSimulation")
		.during(10 seconds) {
			exec(http("request_0")
				.get("/v1/pokemons")
				.headers(headers_0))
		}

	//
	// var feeder = csv("pokemons.csv").circular

	setUp(scn.inject(atOnceUsers(100))).protocols(httpProtocol)
}