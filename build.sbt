import ReleaseTransformations._

organization := "org.konstructs"

name := "konstructs-server"

scalaVersion := "2.11.8"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-language:postfixOps")

val akkaVersion = "2.4.12"

resolvers += "konstructs" at "http://dl.bintray.com/konstructs/maven"

libraryDependencies ++= Seq(
  "org.konstructs" % "konstructs-server-api" % "0.1.20-SNAPSHOT",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "commons-io" % "commons-io" % "2.5",
  "com.google.code.gson" % "gson" % "2.8.0",
  "com.sksamuel.scrimage" %% "scrimage-core" % "2.1.8",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

bintrayOrganization := Some("konstructs")

fork in run := true

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  setNextVersion,
  commitNextVersion,
  pushChanges
)

assemblyJarName in assembly := s"${name.value}-${version.value}.jar"

scalafmtConfig in ThisBuild := Some(file(".scalafmt.conf"))
