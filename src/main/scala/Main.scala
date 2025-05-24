package dev.vanderloureiro

import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault, Console}

object Main extends ZIOAppDefault {

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = ZIO.succeed(println("My ZIO school"))
}
