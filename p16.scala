object P16 {
  def main(args:Array[String]) {
    val res = times(BigInt(2), BigInt(2), 1000).toString().toSeq.map(_.toString().toInt).foldLeft(0)(_ + _)
    println(res)
  }
  def times(multiplicand:BigInt, multiplier:BigInt, power:Int):BigInt = { 
    power match {
      case p if p == 1 => multiplicand
      case _ => times(multiplicand * multiplier, multiplier, power - 1)
    }   
  }
}
