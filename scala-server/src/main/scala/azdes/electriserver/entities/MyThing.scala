package azdes.electriserver.entities

case class MyThing(id: String, title: String, text: String)
case class MyThingUpdate(title: Option[String], text: Option[String])
