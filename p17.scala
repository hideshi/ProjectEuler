object P17 {
	def main(args:Array[String]) {
		val literalList = for {
			i <- 1 to 1000
			val res = makeLiteral(i)
		} yield res 

		//literalList foreach(println _)

		println(literalList.map(_.toSeq.filter(c => c != ' ' && c != '-').length).sum)//.foreach(println _)
	}
			
	val pattern = """(\d)?(\d)?(\d)?(\d)""".r 

	def extract(num:Int):Option[(Int, Int, Int, Int)] = {
		num.toString.reverse.padTo(4, '0') match {
			case pattern(d, c, b, a) => Some((a.toInt * 1000, b.toInt * 100, c.toInt * 10, d.toInt))
			case _ => None
		}
	}

	def makeLiteral(num:Int):String = {
			extract(num) match {
				case Some((0, 0, 0, d)) => numMap.get(d).get
				case Some((0, 0, c, d)) if c == 10 => numMap.get(c + d).get
				case Some((0, 0, c, 0)) => numMap.get(c).get
				case Some((0, 0, c, d)) if c != 10 => numMap.get(c).get + "-" + numMap.get(d).get
				case Some((0, b, 0, 0)) => numMap.get(b / 100).get + " " + numMap.get(100).get
				case Some((0, b, c, d)) if c <= 10 => numMap.get(b / 100).get + " " + numMap.get(100).get + " and " + numMap.get(c + d).get
				case Some((0, b, c, 0)) if c >= 10 => numMap.get(b / 100).get + " " + numMap.get(100).get + " and " + numMap.get(c).get
				case Some((0, b, c, d)) if c >= 10 => numMap.get(b / 100).get + " " + numMap.get(100).get + " and " + numMap.get(c).get + "-" + numMap.get(d).get
				case Some((a, 0, 0, 0)) => numMap.get(a / 1000).get + " " + numMap.get(1000).get
				case _ => throw new IllegalArgumentException("") 
			}
	}

	val numMap =
		Map(
				  0 -> ""	
				 ,1 -> "one"
				 ,2 -> "two"
				 ,3 -> "three"
				 ,4 -> "four"
				 ,5 -> "five"
				 ,6 -> "six"
				 ,7 -> "seven"
				 ,8 -> "eight"
				 ,9 -> "nine"
				 ,10 -> "ten"
				 ,11 -> "eleven"
				 ,12 -> "twelve"
				 ,13 -> "thirteen"
				 ,14 -> "fourteen"
				 ,15 -> "fifteen"
				 ,16 -> "sixteen"
				 ,17 -> "seventeen"
				 ,18 -> "eighteen"
				 ,19 -> "nineteen"
				 ,20 -> "twenty"
				 ,30 -> "thirty"
				 ,40 -> "forty"
				 ,50 -> "fifty"
				 ,60 -> "sixty"
				 ,70 -> "seventy"
				 ,80 -> "eighty"
				 ,90 -> "ninety"
				 ,100 -> "hundred"
				 ,1000 -> "thousand"
		)
}
