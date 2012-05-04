import scala.collection.mutable.ListBuffer
object P12 {
	var lb = ListBuffer[List[Long]]()
	def main(args:Array[String]) {
		println(makeNumber(1L, 1L))
	}
	
	def makeNumber(num:Long, triangular:Long):List[Long] = {
		val div = findDivisor(triangular)
		println(num + ":" + div)
		lb += div
		div.length match {
			case l if l >= 30 => div
			case _ => makeNumber(num + 1, triangular + num + 1)
		}
	}

	def findDivisor(num:Long):List[Long] = {
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
