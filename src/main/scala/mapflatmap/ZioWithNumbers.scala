package dev.vanderloureiro
package mapflatmap

import zio.{Scope, ZIO, ZIOAppArgs, ZIOAppDefault}

object ZioWithNumbers extends ZIOAppDefault {

  val z1 = ZIO.succeed(2)
  val z2 = ZIO.succeed(3)
  val z3 = ZIO.succeed(5)

  // abordagem com for-comprehension
  val program = for {
    value1 <- z1
    value2 <- z2
  } yield (value1 + value2)
  val print1 = program.flatMap(value => ZIO.succeed(println(value)))

  // abordagem com map e flatMap
  val program2 = z1.flatMap(value1 => z2.map(_ + value1))
  val print2 = program2.flatMap(value => ZIO.succeed(println(value)))

  // exemplo mais complexo
  val program3 = z1.flatMap(value1 =>
    z2.flatMap(value2 =>
      z3.map(_ + value1 + value2)
    )
  )
  val print3 = program3.flatMap(value => ZIO.succeed(println(value)))

  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = print1 *> print2 *> print3
}
