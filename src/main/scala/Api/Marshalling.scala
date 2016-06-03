package Api


import MachineLearning.{Line, Point}
import play.api.libs.json.Json

trait JsonMarshalling {

  implicit val pointFormat = Json.format[Point]
  implicit val lineFormat = Json.format[Line]
}
