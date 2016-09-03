package azuaron.electriserver.rest

import scala.concurrent.ExecutionContext

import azuaron.electriserver.rest.mything.MyThingResource

class RestModule(implicit val executionContext: ExecutionContext) extends MyThingResource {
  override val myThingCrud: MyThingCrud = new MyThingCrudService
  val routes = myThingRoutes // ~ myOtherThingRoutes ~ myOtherOtherThingRoutes
}
