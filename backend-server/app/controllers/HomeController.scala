package controllers

import play.api.mvc._

import bazeltest.Main
import com.armeneum.testrepo.TestRepository

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
class HomeController(
    testRepo: TestRepository
)(val controllerComponents: ControllerComponents)
    extends BaseController {

  /**
    * Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index() =
    Action { implicit request: Request[AnyContent] =>
      Ok(testRepo.getThing().b)
    }
}
