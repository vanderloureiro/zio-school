package dev.vanderloureiro
package dependencyinjection

import zio.{IO, ZIO}

trait GetUser {

  def get(id: Long): IO[GetUserError, User]
}

object GetUser {
  
  def get(id: Long): ZIO[GetUser, GetUserError, User] = ZIO.serviceWithZIO[GetUser](_.get(id))
}

case class User(id: Long, username: String, email: String)

sealed trait GetUserError extends Throwable
