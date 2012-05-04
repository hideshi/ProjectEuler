object P22 {
	import scala.io.Source
	def main(args:Array[String]) {
		val raw = Source.fromFile("names.txt").getLines.toList.head
		val names = raw.split(",").map(_.drop(1).dropRight(1)).sortWith(_ < _)
		val scoreList = for {
			(name, i) <- names.zipWithIndex
		} yield (i + 1) * (name.map(c => m.getOrElse(c.toString, 0)).sum)
		println(scoreList.sum)
	}

	val m = Map(
		 "A" -> 1
		,"B" -> 2
		,"C" -> 3
		,"D" -> 4
		,"E" -> 5
		,"F" -> 6
		,"G" -> 7
		,"H" -> 8
		,"I" -> 9
		,"J" -> 10
		,"K" -> 11
		,"L" -> 12
		,"M" -> 13
		,"N" -> 14
		,"O" -> 15
		,"P" -> 16
		,"Q" -> 17
		,"R" -> 18
		,"S" -> 19
		,"T" -> 20
		,"U" -> 21
		,"V" -> 22
		,"W" -> 23
		,"X" -> 24
		,"Y" -> 25
		,"Z" -> 26
	)
}
