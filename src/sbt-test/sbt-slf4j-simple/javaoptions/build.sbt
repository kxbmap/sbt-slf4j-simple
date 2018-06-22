scalaVersion in ThisBuild := "2.12.4"

enablePlugins(Slf4jSimplePlugin)

addSlf4jSimpleSettingsTo(Compile)

inConfig(Compile)(Seq(
  fork in run := true,
  slf4jSimplePropertiesType := Slf4jSimplePropertiesType.JavaOptions,
  slf4jSimpleLogFile := "System.out",
  slf4jSimpleCacheOutputStream := true,
  slf4jSimpleDefaultLogLevel := Slf4jSimpleLogLevel.Warn,
  slf4jSimpleLogLevel += "com.example.Main$" -> Slf4jSimpleLogLevel.Info,
  slf4jSimpleShowDateTime := true,
  slf4jSimpleDateTimeFormat := "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
  slf4jSimpleShowThreadName := false,
  slf4jSimpleShowLogName := false,
  slf4jSimpleShowShortLogName := true,
  slf4jSimpleLevelInBrackets := true,
  slf4jSimpleWarnLevelString := "!!!!"
))
