package controllers

import com.armeneum.testrepo.{ PlayerInsertRequest, PlayerRow, TestRepository }
import com.armeneum.models.JsonFormatters._
import play.api.mvc._

import scala.async.Async.{ async, await }
import scala.concurrent.ExecutionContext

/** This controller creates an `Action` to handle HTTP requests to the application's home page.
  */
class HomeController(
    testRepo: TestRepository
)(val controllerComponents: ControllerComponents)(implicit ec: ExecutionContext)
    extends BaseController {
  import HomeController._

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
        Ok(insertResult.id)(longWriteable)
      }
    }

  def getPlayerById(id: Long) =
    Action.async { _ =>
      async {
        val playerOpt: Option[PlayerRow] = await(testRepo.getPlayerById(id))
        playerOpt match {
          case Some(player) => Ok(player)(playerWriteable)
          case None         => NotFound
        }
      }
    }

  def getAllPlayers() =
    Action.async { _ =>
      async {
        val playerList: List[PlayerRow] = await(testRepo.getAllPlayers())
        Ok(playerList)(listWriteable(playerWrites))
      }
    }
}

object HomeController {
  // Throw in some utilities here
}
