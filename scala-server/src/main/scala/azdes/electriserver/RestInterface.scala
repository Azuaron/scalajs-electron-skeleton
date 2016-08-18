package azdes.electriserver

import azdes.electriserver.resources.MyThingResource
import azdes.electriserver.services.MyThingCrudService
import spray.routing._

import scala.concurrent.ExecutionContext
import scala.language.postfixOps

class RestInterface(implicit val executionContext: ExecutionContext) extends HttpServiceActor with Resources {
  override val myThingService = new MyThingCrudService
  val routes: Route = myThingRoutes

  override def receive = runRoute(routes)
}

object RestInterface {
  def make(implicit executionContext: ExecutionContext): RestInterface = {
    return new RestInterface
  }
}

trait Resources extends MyThingResource
