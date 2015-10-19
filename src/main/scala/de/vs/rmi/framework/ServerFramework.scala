package de.vs.rmi.framework

import java.rmi.Remote
import java.rmi.registry.LocateRegistry
import java.rmi.server.UnicastRemoteObject


object ServerFramework {

  def init[T <% Remote](settings: Settings, server_logic: T) {
    try {
      val something_strange = UnicastRemoteObject.exportObject(server_logic, 0).asInstanceOf[T]
      val registry = LocateRegistry.createRegistry(settings.service_port)
      registry.rebind(settings.service_name, something_strange)
      println("server_ready")
    } catch {
      case e: Exception => {
        println(e)
        System.exit(-1)
      }
    }
  }
}