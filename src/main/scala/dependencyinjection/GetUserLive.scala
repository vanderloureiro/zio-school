package dev.vanderloureiro
package dependencyinjection

import zio.{IO, ZIO, ZLayer}

case class GetUserLive() extends GetUser {

  override def get(id: Long): IO[GetUserError, User] = ZIO.succeed(User(1, "vanderloureiro", "vanderlloureiro@gmail.com"))
}

object GetUserLive {
  val live = ZLayer.succeed(GetUserLive())
}
