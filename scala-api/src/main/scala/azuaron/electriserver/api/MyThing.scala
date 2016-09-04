package azuaron.electriserver.api

case class MyThing(id: String, title: String, text: String)
case class MyThingUpdate(title: Option[String], text: Option[String])

/**
 * Not strictly necessary, but speeds up compilation/runtime.
 */
object MyThing {
  implicit val pkl = upickle.default.macroRW[MyThing]
}

object MyThingUpdate {
  implicit val pkl = upickle.default.macroRW[MyThingUpdate]
}
