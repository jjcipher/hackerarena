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
  .aggregate(library, bench, practice, euler)
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

lazy val practice = (project in file("practice"))
  .dependsOn(library)
  .settings(commonSettings)
  .settings(
    name := "practice"
  ).dependsOn(library)
  .enablePlugins(JmhPlugin)

lazy val euler = project.in(file("compete") / "euler")
  .dependsOn(library)
  .settings(
    commonSettings,
    unmanagedSourceDirectories in Compile := Nil,
    unmanagedSourceDirectories in Test := List(baseDirectory.value)
  )
