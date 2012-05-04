import scala.collection.mutable.ListBuffer
object P7 {
	def main(args: Array[String]) {
		val lb = ListBuffer[Int]()
		var num = 2
		while(lb.length != 10001) {
			if(!(lb exists (prime => num % prime == 0))) lb += num
			num = num + 1
		}
		println(lb.last)
	}
}
