name := "Electron backed by Scala Server"

scalacOptions += "-deprecation"
scalacOptions += "-feature"

addCommandAlias("compileAndRun", "; compile ; electronMain ; electronStart unix")
addCommandAlias("compileAndRunWin32", "; compile ; electronMain ; electronStart win32")
