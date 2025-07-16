package dev.vanderloureiro
package dependencyinjection

import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object Main extends ZIOAppDefault {

  val app: ZIO[GetUser, Throwable, Unit] = for {
    user <- GetUser.get(1)
    _ <- zio.Console.printLine(s"User: $user")
  } yield ()
  
  override def run: ZIO[ZIOAppArgs & Scope, Any, Any] = app.provideLayer(GetUserLive.live)
}
