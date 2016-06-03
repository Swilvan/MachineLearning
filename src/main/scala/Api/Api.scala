package Api

import MachineLearning.{Point, SimpleLinearRegression}
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorFlowMaterializer


object WebServer extends JsonMarshalling {

  def main(args: Array[String]) {
    import octalmind.playjson.PlayJsonSupport
    import PlayJsonSupport._

    implicit val system = ActorSystem("machine-learning")
    implicit val dispatcher = system.dispatcher
    implicit val materializer = ActorFlowMaterializer()

    val route =
      path("hello"){
        complete{
          "Hi"
        }
      }~
      path("simplelinearregression") {
        put {
          entity(as[Set[Point]]) { testData =>
            complete {
              new SimpleLinearRegression(testData).bestFit
            }
          }
        }
      }

    Http().bindAndHandle(route, interface = "127.0.0.1", port = 8080)

  }
}

