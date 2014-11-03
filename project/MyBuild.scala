
import sbt._
import sbt.{Project, Build}
import sbt.Keys._

object MyBuild extends Build {

  override lazy val settings = super.settings ++ Seq(
    scalaVersion := "2.10.4",
    organization := "main.com.samples"
  )

  lazy val sayHello: Project = Project(
    id = "say-hello",
    base = file("say-hello")
  )
    .settings(settings: _*)


  lazy val root: Project = Project(
    id = "root",
    base = file(".")
  )
    .settings(settings: _*)
    .aggregate(sayHello)

}