import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer
object SwapElements {

	def main(args: Array[String]) {
		val a = Array(1,2,3,4,5)
		val q = Array(-1,1,3,-5,-2,0)
		val a2 = Array(1.0, 2.0, 3.0, 4.0, 5.0)
		val a3 = Array(-1, 1, 3, -5, -2, 0, 21, 25, -3)
		
		println(a.mkString(","))
		
		val b = time{ swap(a) }
		println(b.mkString(","))
		
		val c = time{ swap2(a) }
		println(c.mkString(","))
		
		val d = time{ swap3(a) }
		println(d.mkString(","))
		
		val e = split(q)
		println(e.mkString(","))
		
		val av = average(a2)
		println(av)
		
		val att1 = time{split(a3)}
		val att2 = time{split2(a3)}
	}

	def swap(arr: Array[Int]) = {
		val b = new Array[Int](arr.length)
		for(i <- 1 until arr.length by 2) {
			b(i - 1) = arr(i)
			b(i) = arr(i - 1) 
		}
		if(arr.length % 2 == 1) b(arr.length - 1) = arr(arr.length -1)
		b
	}

	def swap3(arr: Array[Int]) = {
		val ret = for(i <- arr.grouped(2); j <- i.reverse) yield j
		ret.toArray
	}

	def swap2(arr: Array[Int]) = {
		arr.grouped(2).flatMap {
			case Array(x,y) => Array(y,x)
			case x => x
		}
	}

	def split(arr: Array[Int]) = {
		val positive = ArrayBuffer[Int]()
		val negative = ArrayBuffer[Int]()
		for(i <- arr) if(i >= 0) positive += i else negative += i
		(positive ++= negative).toArray
	}

	def split2(arr: Array[Int]) = {
		val positive = ListBuffer[Int]() //much better for appends than arrayBuffer
		val negative = ListBuffer[Int]()
		for(i <- arr) if(i >= 0) positive += i else negative += i
		(positive ++= negative).toArray
	}

	//Timing function from @Jesper at http://stackoverflow.com/questions/9160001/how-to-profile-methods-in-scala
	def time[R](block: => R): R = {
	    val t0 = System.nanoTime()
	    val result = block 
	    val t1 = System.nanoTime()
	    println("Elapsed time: " + (t1 - t0) + "ns")
	    result
	}

	def average(arr: Array[Double]) = {
		arr.sum / arr.length
	}

}