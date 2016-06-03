package MachineLearning

class SimpleLinearRegression(testData: Set[Point], alpha: Double = 0.05) {

  val precision = 0.000001

  def factor: Double = 1.0d / testData.size

  val bestFit: Line = gradientDescent(Line(origin = 0, slope = 0))

  def gradientDescent(hypothesis: Line): Line = {
    val newOrigin = hypothesis.origin - alpha * factor * testData.map ( point => hypothesis.origin + hypothesis.slope * point.x - point.y ).sum
    val newSlope = hypothesis.slope - alpha * factor * testData.map ( point => (hypothesis.origin + hypothesis.slope * point.x - point.y) * point.x ).sum
    val newHypothesis: Line = Line(newOrigin, newSlope)
    if ((newOrigin - hypothesis.origin).abs <= precision && (newSlope - hypothesis.slope).abs <= precision) newHypothesis
    else gradientDescent(newHypothesis)
  }
}

object Main extends App {


  override def main(args: Array[String]) {
    val x = new SimpleLinearRegression(Set(Point(1,1), Point(2,2))).bestFit
    println(x)
  }
}