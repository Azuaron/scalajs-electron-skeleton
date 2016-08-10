import java.nio.charset.Charset

name := "Scala Server for Electron"

scalaVersion := "2.11.8"

scalacOptions += "-deprecation"
scalacOptions += "-feature"

persistLauncher in Compile := true
persistLauncher in Test := false
