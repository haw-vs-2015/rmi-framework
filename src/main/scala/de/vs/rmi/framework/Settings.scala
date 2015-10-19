package de.vs.rmi.framework

import scala.xml.XML

object Settings {
    def apply() = new Settings()
}

class Settings {
  val service_settings = XML.load(getClass.getClassLoader.getResourceAsStream("serviceSettings.xml"))
  val service_name = (service_settings \\ "name").text
  val service_host = (service_settings \\ "host").text
  val service_port: Int = (service_settings \\ "port").text.toInt
}