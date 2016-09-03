package azuaron.electriserver.rest.mything

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes._

trait MyThingResource extends MyThingCrudComponentImpl with MyThingJsonSupport {

  val myThingRoutes = pathPrefix("my-thing") {
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
        val myThing = myThingCrud.getMyThing(id)
        onSuccess(myThing) {
          case None => complete(NotFound)
          case Some(myThing) => complete(myThing)
        }
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
