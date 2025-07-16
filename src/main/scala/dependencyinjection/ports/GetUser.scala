package dev.vanderloureiro
package dependencyinjection.ports

import dependencyinjection.User

import zio.{IO, ZIO}

trait GetUser {

  def execute(id: Long): IO[GetUserError, User]
}

object GetUser {

  def execute(id: Long): ZIO[GetUser, GetUserError, User] = ZIO.serviceWithZIO[GetUser](_.execute(id))
}

sealed trait GetUserError
object GetUserError {
  object UnexpectedError extends GetUserError
}
