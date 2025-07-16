package dev.vanderloureiro
package dependencyinjection

import zio.{IO, ZIO}

trait GetUser {

  def get(id: Long): IO[GetUserError, User]
}

object GetUser {
  
  def get(id: Long): ZIO[GetUser, GetUserError, User] = ZIO.serviceWithZIO[GetUser](_.get(id))
}

sealed trait GetUserError
object GetUserError {
  object UnexpectedError extends GetUserError
}
