object P9 {
	def main(args:Array[String]) {
		val l = for{
			a <- 1 to 1000
			b <- 1 to 1000
			if a < b
			c <- 1 to 1000
			if a + b + c == 1000
			if a * a + b * b == c * c
		} yield (a, b, c)
		println(l)
		val (a, b, c) = l.head
		println(a * b * c)
	}
}
