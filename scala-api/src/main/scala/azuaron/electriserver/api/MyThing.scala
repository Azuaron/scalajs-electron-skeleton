package azuaron.electriserver.api

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

case class MyThing(id: String, title: String, text: String)
case class MyThingUpdate(title: Option[String], text: Option[String])

trait MyThingJsonSupport extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val myThingFormat = jsonFormat3(MyThing)
  implicit val myThingUpdateFormat = jsonFormat2(MyThingUpdate)
}
