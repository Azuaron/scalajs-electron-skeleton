package azdes.electriserver

import azdes.electriserver.resources.MyThingResource
import azdes.electriserver.services.MyThingService
import spray.routing._

import scala.concurrent.ExecutionContext
import scala.language.postfixOps

class RestInterface(implicit val executionContext: ExecutionContext) extends HttpServiceActor with Resources {

  def receive = runRoute(routes)

  override val myThingService = new MyThingService

  val routes: Route = myThingRoutes

}

trait Resources extends MyThingResource
