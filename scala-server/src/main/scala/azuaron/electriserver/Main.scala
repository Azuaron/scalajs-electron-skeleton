package azuaron.electriserver

import scala.concurrent.duration._
import scala.io.StdIn

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import azuaron.electriserver.rest.RestModule

object Main extends App {
  //val config = ConfigFactory.load()
  //val host = config.getString("http.host")
  //val port = config.getInt("http.port")
  val host = "localhost"
  val port = 8080

  implicit val system = ActorSystem("rest-actor-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher
  //implicit val timeout = Timeout(10.seconds)

  val restModule = new RestModule

  val bindingFuture = Http().bindAndHandle(restModule.routes, host, port)

  println(s"Server online at $host:$port\nPress RETURN to stop...")
  StdIn.readLine()
  bindingFuture.flatMap(_.unbind()).onComplete(_ => system.terminate())
}
