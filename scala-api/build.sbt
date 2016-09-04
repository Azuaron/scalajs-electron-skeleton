name := "Scala API objects"

version := "0.1-SNAPSHOT"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

//pickling
libraryDependencies ++= {
  Seq(
    "de.heikoseeberger" %% "akka-http-upickle" % "1.9.0", //Apache 2.0
    "com.lihaoyi" %% "upickle" % "0.4.1", //Full rights, custom license? MIT? Who knows!
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test" //MIT License
  )
}
