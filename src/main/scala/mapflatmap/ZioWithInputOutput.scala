package dev.vanderloureiro
package mapflatmap

import zio.Console.{readLine, printLine}
import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object ZioWithInputOutput extends ZIOAppDefault {

  val program1 = printLine("Hello! Whats the your name?") *> readLine.flatMap(name => printLine(s"Welcome to ZIO, $name"))

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = program1
}
