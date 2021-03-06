package azuaron.electriserver.rest.mything

import scala.concurrent.{ExecutionContext, Future}
import azuaron.electriserver.api.{MyThing, MyThingUpdate}

trait MyThingCrudComponent {
  val myThingCrud: MyThingCrud
  trait MyThingCrud {
    def createMyThing(myThing: MyThing): Future[Option[String]]
    def getMyThing(id: String): Future[Option[MyThing]]
    def updateMyThing(id: String, update: MyThingUpdate): Future[Option[MyThing]]
    def deleteMyThing(id: String): Future[Unit]
  }
}

trait MyThingCrudComponentImpl extends MyThingCrudComponent {
  class MyThingCrudService(implicit val executionContext: ExecutionContext) extends MyThingCrud {
    var myThings = Vector.empty[MyThing]

    def createMyThing(myThing: MyThing): Future[Option[String]] = Future {
      myThings.find(_.id == myThing.id) match {
        case Some(q) => None // Conflict! id is already taken
        case None =>
          myThings = myThings :+ myThing
          Some(myThing.id)
      }
    }

    def getMyThing(id: String): Future[Option[MyThing]] = Future {
      myThings.find(_.id == id)
    }

    def updateMyThing(id: String, update: MyThingUpdate): Future[Option[MyThing]] = {
      def updateEntity(myThing: MyThing): MyThing = {
        val title = update.title.getOrElse(myThing.title)
        val text = update.text.getOrElse(myThing.text)
        MyThing(id, title, text)
      }

      getMyThing(id).flatMap { maybeMyThing =>
        maybeMyThing match {
          case None => Future { None } // Nothing found, so that's what we update
          case Some(myThing) =>
            val updatedMyThing = updateEntity(myThing)
            deleteMyThing(id).flatMap { _ =>
              createMyThing(updatedMyThing).map(_ => Some(updatedMyThing))
            }
        }
      }
    }

    def deleteMyThing(id: String): Future[Unit] = Future {
      myThings = myThings.filterNot(_.id == id)
    }
  }
}
