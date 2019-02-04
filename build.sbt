lazy val commonSettings = Seq(
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.3",

  scalacOptions ++= List(
    "-unchecked",
    "-deprecation",
    "-language:_",
    "-encoding", "UTF-8"
  ),
  libraryDependencies ++= Seq(
    "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"
  )
)

lazy val root = (project in file("."))
  .aggregate(library, bench, hackerrank, euler)
  .settings(
    commonSettings
  )

lazy val library = (project in file("library"))
  .settings(commonSettings)
  .settings(
    name := "library",
    fork in Test := true,
    javaOptions in Test += "-Xss1M"
  )

lazy val bench = (project in file("bench"))
  .settings(commonSettings)
  .settings(
    name := "bench"
  ).dependsOn(library)
  .enablePlugins(JmhPlugin)

lazy val hackerrank = (project in file("hackerrank"))
  .dependsOn(library)
  .settings(commonSettings)
  .settings(
    name := "hackerrank"
  ).dependsOn(library)

lazy val euler = project.in(file("euler"))
  .dependsOn(library)
  .settings(commonSettings)
  .settings(
    name := "euler"
  ).dependsOn(library)
