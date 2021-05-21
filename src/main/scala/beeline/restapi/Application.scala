package beeline.restapi

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.complete
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContextExecutor

object Application {
  def start(): Unit ={
    implicit val system: ActorSystem = ActorSystem()
    implicit val materialize: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val routes = complete("Running...")

    val bindingFuture = Http().bindAndHandle(routes, "localhost", 8001).recoverWith{
      case _ => sys.exit(1)
    }

    sys.addShutdownHook{
      bindingFuture.map(_.unbind())
    }
  }

  def main(args: Array[String]): Unit = {
    start()
  }
}