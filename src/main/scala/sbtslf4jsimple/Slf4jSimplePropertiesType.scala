package sbtslf4jsimple

sealed trait Slf4jSimplePropertiesType

object Slf4jSimplePropertiesType {

  case object Resource extends Slf4jSimplePropertiesType

  case object JavaOptions extends Slf4jSimplePropertiesType

}
