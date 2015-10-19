package de.vs.rmi.framework

import java.rmi.Remote
import java.rmi.registry.LocateRegistry

object ClientFramework {

  def init[T <: Remote](settings: Settings, logic_callback: (T) => Unit) {
      val registry = LocateRegistry.getRegistry(settings.service_host, settings.service_port)
      val request = registry.lookup(settings.service_name).asInstanceOf[T]
      logic_callback(request)
  }

  def init[T <: Remote](settings: Settings): T = {
      val registry = LocateRegistry.getRegistry(settings.service_host, settings.service_port)
      val request = registry.lookup(settings.service_name).asInstanceOf[T]
      request
  }
}