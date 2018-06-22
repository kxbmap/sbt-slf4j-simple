package sbtslf4jsimple

import sbt.Keys._
import sbt._
import sbtslf4jsimple.Slf4jSimpleKeys._

object Slf4jSimplePlugin extends AutoPlugin {

  val DefaultSlf4jSimpleVersion = "1.7.25"

  override def requires: Plugins = plugins.JvmPlugin

  object autoImport extends Slf4jSimpleKeys {

    type Slf4jSimplePropertiesType = sbtslf4jsimple.Slf4jSimplePropertiesType
    val Slf4jSimplePropertiesType = sbtslf4jsimple.Slf4jSimplePropertiesType

    type Slf4jSimpleLogLevel = sbtslf4jsimple.Slf4jSimpleLogLevel
    val Slf4jSimpleLogLevel = sbtslf4jsimple.Slf4jSimpleLogLevel

    def addSlf4jSimpleSettingsTo(conf: Configuration): Seq[Setting[_]] =
      slf4jSimpleScopedSettings(conf)

  }

  override def projectSettings: Seq[Setting[_]] = Seq(
    slf4jSimpleVersion := DefaultSlf4jSimpleVersion
  )

  def slf4jSimpleScopedSettings(conf: Configuration): Seq[Setting[_]] = Seq(
    libraryDependencies += "org.slf4j" % "slf4j-simple" % slf4jSimpleVersion.value % conf
  ) ++ inConfig(conf)(Seq(
    slf4jSimplePropertiesType := Slf4jSimplePropertiesType.JavaOptions,
    slf4jSimpleProperties := propertiesSetting.value,
    slf4jSimpleLogLevel := Seq.empty,
    slf4jSimpleGeneratePropertyFile := generatePropertyFileTask.value,
    resourceGenerators ++= {
      slf4jSimplePropertiesType.value match {
        case Slf4jSimplePropertiesType.Resource => slf4jSimpleGeneratePropertyFile.map(Seq(_)).taskValue :: Nil
        case Slf4jSimplePropertiesType.JavaOptions => Nil
      }
    },
    javaOptions in run ++= {
      slf4jSimplePropertiesType.value match {
        case Slf4jSimplePropertiesType.Resource => Nil
        case Slf4jSimplePropertiesType.JavaOptions => javaOptionsTask.value
      }
    }
  ))

  private def propertiesSetting = Def.setting[Seq[(String, String)]] {
    (Seq(
      "logFile" -> slf4jSimpleLogFile.?.value,
      "cacheOutputStream" -> slf4jSimpleCacheOutputStream.?.value,
      "defaultLogLevel" -> slf4jSimpleDefaultLogLevel.?.value,
      "showDateTime" -> slf4jSimpleShowDateTime.?.value,
      "dateTimeFormat" -> slf4jSimpleDateTimeFormat.?.value,
      "showThreadName" -> slf4jSimpleShowThreadName.?.value,
      "showLogName" -> slf4jSimpleShowLogName.?.value,
      "showShortLogName" -> slf4jSimpleShowShortLogName.?.value,
      "levelInBrackets" -> slf4jSimpleLevelInBrackets.?.value,
      "warnLevelString" -> slf4jSimpleWarnLevelString.?.value
    ).collect {
      case (k, Some(v)) => (k, v.toString)
    } ++ slf4jSimpleLogLevel.value.map {
      case (k, v) => (s"log.$k", v.toString)
    }).map {
      case (k, v) => (s"org.slf4j.simpleLogger.$k", v)
    }
  }

  private def generatePropertyFileTask = Def.task[File] {
    val file = resourceManaged.value / "simplelogger.properties"
    val props = slf4jSimpleProperties.value.map {
      case (k, v) => s"$k=$v"
    }
    IO.writeLines(file, props)
    file
  }

  private def javaOptionsTask = Def.task[Seq[String]] {
    slf4jSimpleProperties.value.map {
      case (k, v) => s"-D$k=$v"
    }
  }

}
