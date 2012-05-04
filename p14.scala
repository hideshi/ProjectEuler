import scala.collection.mutable.ListBuffer
object P14 {
	def main(args:Array[String]) {
		var lb = ListBuffer[List[Long]]()
		var len = 0
		for(i <- 1 to 1000000) {
			val res = process(i, List())
			if(res.length > len) {
				lb += res
				len = res.length
			}
		}
		println(lb.sortWith(_.length > _.length).head.reverse.head)
	}
	@scala.annotation.tailrec
	def process(num:Long, l:List[Long]):List[Long] = {
		num match {
			case n if n == 1L => n :: l
			case n if n % 2L == 0L => process(n / 2L, n :: l)
			case n => process(3L * n + 1L, n :: l)
		}
	}
}
