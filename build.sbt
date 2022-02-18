val scala3Version = "3.1.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scalacheckInnoDay",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",
    libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.15.4" % "test",
    libraryDependencies += "org.scalatestplus" %% "scalacheck-1-15" % "3.2.11.0" % "test",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test"
  )
