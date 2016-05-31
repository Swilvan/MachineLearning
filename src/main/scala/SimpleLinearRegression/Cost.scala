package SimpleLinearRegression

import scala.math.pow

class Cost(testData: Set[(Double, Double)]) {

  def squaredError(hypothesis: Line): Double = {
    val factor = 1.0d / (2 * testData.size)
    val error: Double = testData.map { case (x: Double, y: Double) => pow((hypothesis.y(x) - y), 2.0d) }.reduce((acc, next) => acc + next)
    factor * error
  }

}
