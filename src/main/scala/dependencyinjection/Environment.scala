package dev.vanderloureiro
package dependencyinjection

import zio.ZLayer

object Environment {

  private type AppEnv = GetUser with UserRepository

  val appLayer: ZLayer[Any, Nothing, AppEnv] = ZLayer.make[AppEnv](UserRepositoryLive.live, GetUserLive.live)

}
