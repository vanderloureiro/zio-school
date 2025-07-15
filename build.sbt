ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.6"

libraryDependencies += "dev.zio" %% "zio" % "2.1.18"
libraryDependencies += "dev.zio" %% "zio-http" % "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "zio-school",
    idePackagePrefix := Some("dev.vanderloureiro")
  )
