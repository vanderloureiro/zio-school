package dev.vanderloureiro
package dependencyinjection.adapters

import dependencyinjection.User
import dependencyinjection.ports.UserRepository

import zio.{ULayer, ZIO, ZLayer}

case class UserRepositoryLive() extends UserRepository {

  override def findById(id: Long): ZIO[Any, Nothing, Option[User]] = {
    if (id != 1L) {
      ZIO.succeed(Option.empty)
    } else {
      ZIO.some(User(1, "Vanderlei", "vanderlloureiro@gmail.com"))
    }
  }
}

object UserRepositoryLive {
  val live: ULayer[UserRepository] = ZLayer.succeed[UserRepository](UserRepositoryLive())
}
