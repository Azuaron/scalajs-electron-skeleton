name := "Scala API objects"

version := "0.1-SNAPSHOT"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

//spray
libraryDependencies ++= {
  val akkaV = "2.4.9"
  Seq(
    "com.typesafe.akka"   %%  "akka-http-spray-json-experimental"  % akkaV,
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test"
  )
}
