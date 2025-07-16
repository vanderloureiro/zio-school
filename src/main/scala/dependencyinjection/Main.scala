package dev.vanderloureiro
package dependencyinjection

import dev.vanderloureiro.dependencyinjection.ports.GetUser
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object Main extends ZIOAppDefault {

  val app = for {
    user <- GetUser.execute(1)
    _ <- zio.Console.printLine(s"User: $user")
  } yield ()

  override def run: ZIO[ZIOAppArgs & Scope, Any, Any] = app.provideLayer(Environment.appLayer)
}
