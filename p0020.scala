object P20 {
	def main(args:Array[String]) {
		println(factorial(100).product.toString.map(_.toString.toInt).sum)
	}

	def factorial(n:Int):List[BigInt] = {
		n match {
			case num if num == 1 => List(BigInt(1))
			case num => BigInt(num) :: factorial(num - 1)
		}
	}
}
