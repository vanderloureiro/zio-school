package dev.vanderloureiro
package dependencyinjection.ports

import dependencyinjection.User

import zio.{IO, ZIO}

trait UserRepository {

  def findById(id: Long): ZIO[Any, Nothing, Option[User]]
}

object UserRepository {
  def findById(id: Long): ZIO[UserRepository, Nothing, Option[User]] = ZIO.serviceWithZIO[UserRepository](_.findById(id))
}

