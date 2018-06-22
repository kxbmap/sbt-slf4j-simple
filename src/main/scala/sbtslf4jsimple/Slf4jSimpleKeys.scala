package sbtslf4jsimple

import sbt._

trait Slf4jSimpleKeys {

  lazy val slf4jSimpleVersion = settingKey[String]("slf4j-simple version")

  lazy val slf4jSimplePropertiesType = settingKey[Slf4jSimplePropertiesType]("")
  lazy val slf4jSimpleProperties = settingKey[Seq[(String, String)]]("SimpleLogger properties")

  lazy val slf4jSimpleLogFile = settingKey[String]("org.slf4j.simpleLogger.logFile")
  lazy val slf4jSimpleCacheOutputStream = settingKey[Boolean]("org.slf4j.simpleLogger.cacheOutputStream")
  lazy val slf4jSimpleDefaultLogLevel = settingKey[Slf4jSimpleLogLevel]("org.slf4j.simpleLogger.defaultLogLevel")
  lazy val slf4jSimpleLogLevel = settingKey[Seq[(String, Slf4jSimpleLogLevel)]]("org.slf4j.simpleLogger.log")
  lazy val slf4jSimpleShowDateTime = settingKey[Boolean]("org.slf4j.simpleLogger.showDateTime")
  lazy val slf4jSimpleDateTimeFormat = settingKey[String]("org.slf4j.simpleLogger.dateTimeFormat")
  lazy val slf4jSimpleShowThreadName = settingKey[Boolean]("org.slf4j.simpleLogger.showThreadName")
  lazy val slf4jSimpleShowLogName = settingKey[Boolean]("org.slf4j.simpleLogger.showLogName")
  lazy val slf4jSimpleShowShortLogName = settingKey[Boolean]("org.slf4j.simpleLogger.showShortLogName")
  lazy val slf4jSimpleLevelInBrackets = settingKey[Boolean]("org.slf4j.simpleLogger.levelInBrackets")
  lazy val slf4jSimpleWarnLevelString = settingKey[String]("org.slf4j.simpleLogger.warnLevelString")

  lazy val slf4jSimpleGeneratePropertyFile = taskKey[File]("Generate simplelogger.properties")

}

object Slf4jSimpleKeys extends Slf4jSimpleKeys
