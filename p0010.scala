import scala.collection.mutable.ListBuffer
object P10 {
	def main(args:Array[String]) {
		val lb = ListBuffer[Long]()
		var count = 2L 
		while(count <= 2000000) {
			if(!(lb.exists(count % _ == 0L))) lb += count
			count = count + 1L
		}
		val sum = lb.toList.foldLeft(0L)(_ + _)
		println(sum)
	}
}
