object P21 {
	import scala.collection.mutable.ListBuffer

	val lb = ListBuffer[List[Long]]()

	def main(args:Array[String]) {
		val l =
		for {
			i <- 2L until 10000L
			val res = amicable(i)
		} yield res
		println(l.filter(_ != List(0L)).flatten.distinct)
		println(l.filter(_ != List(0L)).flatten.distinct.sum)
	}

	def amicable(n:Long):List[Long] = {
		val num1 = findFactor(n).init.sum
		val num2 = findFactor(num1).init.sum
		if(n != num1 && n == num2) {
			 n :: List(num1)
		} else {
			List(0L)
		}
	}

	def findFactor(num:Long):List[Long] = {
		val l = lb.reverse.find(n => (num % n.last == 0 && n.last != 1L))
		val start =
			l match {
				case Some(n) => n
				case None    => List(0L)
			}
		val end = for{
			i <- (((start.last+1L) to num) toList)
			if num % i == 0L
		} yield i
		start match {
			case List(0L) => end
			case _ => start ::: end
		}
	}
}
