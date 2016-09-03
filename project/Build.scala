import sbt._
import Keys._

object ElectronServerBuild extends Build {
	override lazy val settings = super.settings ++ Seq(organization := "azdes",
														version := "0.1-SNAPSHOT",
														scalaVersion := "2.11.8"
													)
	
	lazy val scalajs = (project in file("scalajs"))
		.settings(settings: _*)
		.settings()
	
	lazy val scalaServer = (project in file("scala-server"))
		.settings(settings: _*)
		.settings()
	
	lazy val root = (project in file("."))
		.settings(settings: _*)
		.settings(
			commands += ElectronCommands.electronStart
		)
		.aggregate(scalajs, scalaServer)
}

object ElectronCommands {
	def electronStart = Command.single("electronStart") {
		case (state, "win32") =>
			val success = "./electron-app/node_modules/.bin/electron.cmd electron-app" ! ;
			println(s"Electron app exit: $success")
			state
		case (state, _) =>
			val success = "./electron-app/node_modules/.bin/electron electron-app" ! ;
			println(s"Electron app exit: $success")
			state
	}
}
