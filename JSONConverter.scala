import spray.json._
import DefaultJsonProtocol._ // !!! IMPORTANT, else `convertTo` and `toJson` won't work

// https://github.com/spray/spray-json

case class XY_JSON(key: String, values: Seq[Map[String, Double]], color: String)

object MyJsonProtocol extends DefaultJsonProtocol {
  implicit val XYFormat = jsonFormat3(XY_JSON)
}

object JSONConverter {
  def main(args: Array[String]) = {

    var mappedVar = Map[String, String] { "X" -> ""; "Y" -> ""; "Z" -> "" }


    val XYZTable = List(Array(1.5, 1.8, 3.0),Array(2.5, 8.8, 3.2),Array(0.5, 1.0, 1.2))

    val xyzMappedTable = XYZTable.map { v ⇒
      Map[String, Double]("x" -> v(0), "y" -> v(1), "size" -> v(2))
    }.toIndexedSeq

    val cities = List("Paris","NY","Tokyo")
    val colors = List("F88C12","F00000","CCCCCC")

    import MyJsonProtocol._

    val JsonData = cities.zip(colors).map{ case (ci,co) => XY_JSON(ci, xyzMappedTable, "#"+co)}.toJson

    println(JsonData.toString())

  }
}
