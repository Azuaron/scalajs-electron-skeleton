package azuaron.electriserver.rest.mything

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes._

trait MyThingResource extends MyThingCrudComponentImpl with MyThingJsonSupport {

  val myThingRoutes = pathPrefix("my-things") {
    pathEnd {
      post {
        entity(as[MyThing]) { myThing =>
          val myNewThing = myThingCrud.createMyThing(myThing)
          onSuccess(myNewThing) {
            case None => complete(Conflict)
            case Some(myThing) => complete(Created)
          }
        }
      }
    } ~
    path(Segment) { id =>
      get {
        complete(myThingCrud.getMyThing(id))
      } ~
      put {
        entity(as[MyThingUpdate]) { update =>
          complete(myThingCrud.updateMyThing(id, update))
        }
      } ~
      delete {
        //Fire and forget
        myThingCrud.deleteMyThing(id)
        complete(NoContent)
      }
    }
  }
}
