package dev.vanderloureiro
package web

import zio.http.{Method, Response, Root, Routes, Server, handler}
import zio.{Scope, UIO, ZIO, ZIOAppArgs, ZIOAppDefault}

object ZioHttp extends ZIOAppDefault {

  val homeRoute = Method.GET / Root -> handler(Response.text("Hello World!"))

  val jsonRoute = Method.GET / "json" -> handler(Response.json("""{"greetings": "Hello World!"}"""))

  val app = Routes(homeRoute, jsonRoute)

  override def run = Server.serve(app).provide(Server.defaultWithPort(8080))
}
