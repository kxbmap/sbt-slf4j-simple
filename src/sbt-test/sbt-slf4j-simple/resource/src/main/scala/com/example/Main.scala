package com.example

import org.slf4j.LoggerFactory

object Main extends App {

  val logger = LoggerFactory.getLogger(getClass)
  logger.info("Hello, World!")
  logger.warn("Warning")

}
