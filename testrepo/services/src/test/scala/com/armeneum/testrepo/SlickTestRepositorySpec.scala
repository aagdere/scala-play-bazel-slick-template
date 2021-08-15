package com.armeneum.testrepo

import java.time.LocalDate
import org.scalatest.flatspec.AnyFlatSpec
import slick.jdbc.JdbcBackend.Database

import scala.concurrent.{ Await, Future }
import scala.concurrent.duration.DurationInt

class SlickTestRepositorySpec extends AnyFlatSpec {
  import SlickTestRepositorySpec._

  behavior of "SlickTestRepository"

  it must "insert, retrieve, and delete players" in {
    val repo = makeRepo()

    val player1Id: Long = insertAndVerifyPlayer(repo)("Aris")
//    val player2Id: Long = insertAndVerifyPlayer(repo)("Haig")
  }

  it must "retrieve all players" in {
    val repo = makeRepo()

    repo.getAllPlayers().futureValue
  }

  private def insertAndVerifyPlayer(repo: SlickTestRepository)(name: String): Long = {
    val playerInsertRequest =
      PlayerInsertRequest(
        name = s"$name-Test",
        country = "USA-Test",
        dob = Some(LocalDate.now())
      )

    val playerId = repo.insertPlayer(playerInsertRequest).futureValue.id

    val playerRow = repo.getPlayerById(playerId).futureValue.getOrElse(failToRetrievePlayer(playerId))
    assert(playerRow.id === playerId)
    assert(playerRow.name === playerInsertRequest.name)
    assert(playerRow.country === playerInsertRequest.country)
    assert(playerRow.dob === playerInsertRequest.dob)

    playerId
  }

  object SlickTestRepositorySpec {
    def makeRepo(): SlickTestRepository = {
      val db: Database = Database.forConfig("postgres")
      new SlickTestRepository(db)
    }

    implicit class FutHelper[A](fut: Future[A]) {
      def futureValue: A =
        Await.result(
          awaitable = fut,
          atMost = 5.seconds
        )
    }

    def failToRetrievePlayer(playerId: Long) = fail(s"Can't find player in DB: $playerId")
  }
}
