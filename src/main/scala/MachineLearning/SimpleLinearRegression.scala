package MachineLearning

class SimpleLinearRegression(testData: Set[(Double, Double)], alpha: Double = 0.05) {

  val precision = 0.000001

  def factor: Double = 1.0d / testData.size

  val bestFit: Line = gradientDescent(Line(origin = 0, slope = 0))

  def gradientDescent(hypothesis: Line): Line = {
    val newOrigin = hypothesis.origin - alpha * factor * testData.map { case (x, y) => hypothesis.origin + hypothesis.slope * x - y }.sum
    val newSlope = hypothesis.slope - alpha * factor * testData.map { case (x, y) => (hypothesis.origin + hypothesis.slope * x - y) * x }.sum
    val newHypothesis: Line = Line(newOrigin, newSlope)
    if ((newOrigin - hypothesis.origin).abs <= precision && (newSlope - hypothesis.slope).abs <= precision) newHypothesis
    else gradientDescent(newHypothesis)
  }
}

object Main extends App {


  override def main(args: Array[String]) {
    val x = new SimpleLinearRegression(Set((1d, 1d), (2d, 2d))).bestFit
    println(x)
  }
}