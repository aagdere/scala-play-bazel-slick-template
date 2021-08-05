package com.armeneum.testrepo

import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

class SlickTestRepository(db: Database) extends TestRepository {
  val PlayerTable = TableQuery[PlayerTable]

  def getPlayerById(id: Long): Future[Option[PlayerRow]] =
    db.run(PlayerTable.filter(_.id === id).result.headOption)

  def getAllPlayers(): Future[List[PlayerRow]] =
    db.run(PlayerTable.to[List].result)

  def insertPlayer(request: PlayerInsertRequest): Future[PlayerRow] =
    db.run(PlayerTable.returning(PlayerTable) += request.toRow())
}
