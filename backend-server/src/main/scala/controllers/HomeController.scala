package controllers

import com.armeneum.testrepo.{ PlayerInsertRequest, PlayerRow, TestRepository }
import com.armeneum.models.JsonFormatters._
import play.api.http.Writeable
import play.api.libs.json.Json
import play.api.mvc._

import scala.async.Async.{ async, await }
import scala.concurrent.ExecutionContext

/** This controller creates an `Action` to handle HTTP requests to the application's home page.
  */
class HomeController(
    testRepo: TestRepository
)(val controllerComponents: ControllerComponents)(implicit ec: ExecutionContext)
    extends BaseController {

  /** Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method will be called when the application receives a `GET`
    * request with a path of `/`.
    */
  def index() =
    Action { _ =>
      Ok("Hello, World!")
    }

  def insertPlayer() =
    Action.async(parse.json[PlayerInsertRequest](playerReads)) { request =>
      async {
        val playerToInsert          = request.body
        val insertResult: PlayerRow = await(testRepo.insertPlayer(playerToInsert))
        Ok(insertResult.id)(longWrites.toWriteable())
      }
    }

  def getPlayerById(id: Long) =
    Action.async { _ =>
      async {
        val playerOpt: Option[PlayerRow] = await(testRepo.getPlayerById(id))
        playerOpt match {
          case Some(player) => Ok(player)(playerWrites.toWriteable())
          case None         => NotFound
        }
      }
    }

  def getAllPlayers() =
    Action.async { _ =>
      async {
        val playerList: List[PlayerRow] = await(testRepo.getAllPlayers())
        implicit val playerListWriteable: Writeable[List[PlayerRow]] = playerWrites
          .toListWrites()
          .wrapWithResult()
          .toWriteable()
        Ok(playerList)
      }
    }
}

object HomeController {
  // Throw in some utilities here
}
