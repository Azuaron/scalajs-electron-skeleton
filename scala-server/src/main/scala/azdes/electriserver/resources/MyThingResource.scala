package azdes.electriserver.resources

import azdes.electriserver.entities.{MyThingUpdate, MyThing}
import azdes.electriserver.routing.MyHttpService
import azdes.electriserver.services.MyThingCrudService
import spray.routing._

trait MyThingResource extends MyHttpService {

  val myThingService: MyThingCrudService

  def myThingRoutes: Route = pathPrefix("my-things") {
    pathEnd {
      post {
        entity(as[MyThing]) { myThing =>
          completeWithLocationHeader(
            resourceId = myThingService.createMyThing(myThing),
            ifDefinedStatus = 201, ifEmptyStatus = 409)
          }
        }
    } ~
    path(Segment) { id =>
      get {
        complete(myThingService.getMyThing(id))
      } ~
      put {
        entity(as[MyThingUpdate]) { update =>
          complete(myThingService.updateMyThing(id, update))
        }
      } ~
      delete {
        complete(204, myThingService.deleteMyThing(id))
      }
    }
  }
}
