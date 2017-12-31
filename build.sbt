sbtPlugin := true

name := "sbt-slf4j-simple"
description := "sbt plugin for slf4j-simple"
organization := "com.github.kxbmap"

crossSbtVersions := Seq("1.0.4", "0.13.16", "1.1.0-RC4")

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-Xlint"
)
