package com.armeneum.server

import play.api._
import play.api.ApplicationLoader.Context
import play.api.routing.Router
import play.filters.HttpFiltersComponents
import com.armeneum.testrepo.{ SlickTestRepository, TestRepository }

class BackendServerLoader extends ApplicationLoader {
  def load(context: Context) = {
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment, context.initialConfiguration, Map.empty)
    }
    new MyComponents(context).application
  }
}

class MyComponents(context: Context)
    extends BuiltInComponentsFromContext(context)
    with HttpFiltersComponents
    with _root_.controllers.AssetsComponents {

  lazy val testRepository: TestRepository = new SlickTestRepository()

  lazy val homeController = new _root_.controllers.HomeController(testRepository)(controllerComponents)

  lazy val router: Router = new _root_.router.Routes(httpErrorHandler, homeController, assets)
}
