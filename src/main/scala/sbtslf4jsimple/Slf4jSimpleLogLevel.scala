package sbtslf4jsimple

sealed abstract class Slf4jSimpleLogLevel(override val toString: String)

object Slf4jSimpleLogLevel {

  case object Trace extends Slf4jSimpleLogLevel("trace")
  case object Debug extends Slf4jSimpleLogLevel("debug")
  case object Info extends Slf4jSimpleLogLevel("info")
  case object Warn extends Slf4jSimpleLogLevel("warn")
  case object Error extends Slf4jSimpleLogLevel("error")
  case object Off extends Slf4jSimpleLogLevel("off")

}
