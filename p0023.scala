//Not fixed
object P23 {
	import scala.collection.mutable.ListBuffer
	val lb = ListBuffer[List[Long]]()
	val abundantNumbers = ListBuffer[Long]()

	def main(args:Array[String]) {
		val l = (for {
			i <- 2 to 28123
			val j = getAbundantNumber(i.toLong)
			if(j != None)
		} yield j.get.toInt).toStream

		//ここのfor式が効率悪いらしくOutOfMemoryが発生する
		val m = for {
			i <- l.head to l.last
			j <- l.head to l.last
		} yield i + j

		val result = (2 to 28123).diff(m.sortWith(_ < _).distinct).sum
		println(result)	
	}

	def getAbundantNumber(num:Long):Option[Long] = {
		val factor = findFactor(num).init
		val res = compareFactor(num, factor)
	}

	def compareFactor(num:Long, factor:List[Long]):Option[Long] = {
		val sum = factor.foldLeft(0)(_.toInt + _.toInt)
		if(num == sum) None
		else if(num > sum) None
		else Some(num)
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
