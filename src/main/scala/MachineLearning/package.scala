/**
  * Created by silvan1 on 31/05/16.
  */
package object MachineLearning {

  case class Line(origin:Double, slope:Double){
    def y(x:Double):Double = origin + slope * x
  }

  case class Point(x:Double, y:Double)

}
