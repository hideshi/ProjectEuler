object P5 {
  def main(args: Array[String]):Unit = { 
    val res = calc(1, 20, 20, (num1: Int, num2: Int) => num1 % num2 == 0)  
    println(res)
  }
  def calc(dividend: Int, divisor: Int, start: Int, func: (Int, Int) => Boolean):Int = { 
    divisor match {
      case num if num == 1 => dividend
      case _               => if(func(dividend, divisor)) calc(dividend, divisor - 1, start, func)
                              else calc(dividend + 1, start, start, func)
    }   
  }
}
