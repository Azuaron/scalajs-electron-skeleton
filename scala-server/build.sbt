name := "Scala Server for Electron"

version := "0.1-SNAPSHOT"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

//spray
libraryDependencies ++= {
  val akkaV = "2.4.9"
  Seq(
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV, //Apache 2.0
    "com.typesafe.akka"   %%  "akka-slf4j"    % akkaV, //Apache 2.0
    "com.typesafe.akka"   %%  "akka-http-experimental"  % akkaV, //Apache 2.0
    "com.lihaoyi" %% "upickle" % "0.4.1", //Full rights. Custom license? MIT? Who knows!
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test", //Apache 2.0
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test" //MIT License
  )
}

Revolver.settings
