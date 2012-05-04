object P4 {
	def main(args: Array[String]) {
		val nums =
			for{
				i <- 100 to 999
				j <- 100 to 999
			} yield i * j

		val result = nums filter (num => checkCircularNotice(num.toString().toSeq)) map (_.toInt) sortWith(_ > _)
		println(result.head)
	}

	def checkCircularNotice(s: Seq[Char]): Boolean = {
		s match {
 			 case s if s.length % 2 == 0 => val (x, y) = s.splitAt(s.length / 2)
																	 		if(x == y.reverse) true else false
			 case s if s.length % 2 == 1 => val (x, y) = s.splitAt((s.length - 1) / 2)
																			if(x == y.tail.reverse) true else false
		}
	}
}
