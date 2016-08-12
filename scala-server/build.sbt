name := "Scala Server for Electron"

version := "0.1-SNAPSHOT"

// Dependency Injection
libraryDependencies += "com.google.inject" % "guice" % "4.1.0"
libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.0"
libraryDependencies += "org.eclipse.jetty" % "jetty-server" % "9.3.11.v20160721"

scalacOptions += "-deprecation"
scalacOptions += "-feature"

