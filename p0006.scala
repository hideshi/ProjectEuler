object P6 {
	def main(args: Array[String]) {
		val num1 = ((1 to 100).foldLeft(0)((a, b) => a + b))
		val num2 = (1 to 100).map(a => a * a).foldLeft(0)((a, b) => a + b)
		 println(num1 * num1 - num2)
	}
}
