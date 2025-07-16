package dev.vanderloureiro
package dependencyinjection.adapters

import dependencyinjection.User
import dependencyinjection.ports.{GetUserError, GetUser, UserRepository}

import zio.{IO, ZIO, ZLayer}

case class GetUserLive(repository: UserRepository) extends GetUser {

  override def execute(id: Long): IO[GetUserError, User] = for {
    user <- repository.findById(id)
    _ <- ZIO.fail(GetUserError.UnexpectedError).unless(user.nonEmpty)
  } yield user.get

}

object GetUserLive {
  val live = ZLayer {
    for {
      repository <- ZIO.service[UserRepository]
    } yield GetUserLive(repository)
  }
}
