import scala.collection.mutable.Map
import scala.annotation.tailrec

object NoSolutionException extends Exception{}

object TwoSum{

	val myMap = Map[Int,Int]()

	def main(args: Array[String]){
		val l = List(2,7,11,15,3,27,4,0)
		val target = 26
		try{
			println(twoSum(l,target))
		} catch {
			case NoSolutionException => println("No solution found. Sorry...")
		}
	}

	def twoSum(nums: List[Int], target: Int) = {
		@tailrec
		def recursiveComplement(nums: List[Int], target: Int, index: Int): List[Int] = {
			if(nums.length == 0) throw NoSolutionException
			val ret = myMap.get(target - nums.head)
			ret match {
				case Some(ret) => List(ret, index)
				case None => myMap(nums.head) = index; recursiveComplement(nums.tail, target, index + 1)
			}
		}
		recursiveComplement(nums, target, 0)
	}
}