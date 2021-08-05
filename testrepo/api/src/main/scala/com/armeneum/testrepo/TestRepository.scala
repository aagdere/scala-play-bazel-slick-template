package com.armeneum.testrepo

import scala.concurrent.Future

trait TestRepository {

  def getPlayerById(id: Long): Future[Option[PlayerRow]]

  def getAllPlayers(): Future[List[PlayerRow]]

  def insertPlayer(request: PlayerInsertRequest): Future[PlayerRow]
}
