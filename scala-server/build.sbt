name := "Scala Server for Electron"

version := "0.1-SNAPSHOT"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

//spray
libraryDependencies ++= {
  val akkaV = "2.4.9"
  val sprayV = "1.3.3"
  val json4sV = "3.4.0"
  Seq(
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-slf4j"    % akkaV,
    "com.typesafe.akka"   %%  "akka-http-experimental"  % akkaV,
    "com.typesafe.akka"   %%  "akka-http-spray-json-experimental"  % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test",
    "org.json4s" %% "json4s-native" % json4sV,
    "org.json4s" %% "json4s-ext" % json4sV
  )
}

Revolver.settings
