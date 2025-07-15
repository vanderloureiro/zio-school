package dev.vanderloureiro

import zio.Console.{printLine, readLine}
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object Main extends ZIOAppDefault {

  val myAppLogic =
    for {
      _ <- printLine("Hello! What is your name?")
      name <- readLine
      _ <- printLine(s"Hello, ${name}, welcome to ZIO!")
    } yield ()

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = myAppLogic
}
