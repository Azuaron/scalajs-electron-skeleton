package azdes.electriserver

import akka.actor._
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import com.typesafe.config.ConfigFactory
import spray.can.Http

import scala.concurrent.duration._
import azdes.electriserver.rest.RestInterface

object Main extends App {
  //val config = ConfigFactory.load()
  //val host = config.getString("http.host")
  //val port = config.getInt("http.port")
  val host = "localhost"
  val port = 8080

  implicit val system = ActorSystem("rest-service")
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(10.seconds)

  val api = system.actorOf(Props(RestInterface.make))

  IO(Http).ask(Http.Bind(listener = api, interface = host, port = port))
    .mapTo[Http.Event]
    .map {
      case Http.Bound(address) =>
        println(s"REST interface bound to $address")
      case Http.CommandFailed(cmd) =>
        println("REST interface could not bind to $host:$port, ${cmd.failureMessage}")
        system.terminate()
    }
}
