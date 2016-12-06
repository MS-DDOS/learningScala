import scala.collection.mutable.Map
import scala.annotation.tailrec

object NoSolutionException extends Exception{}

object TwoSum{

	def main(args: Array[String]){
		val l = List(2,7,11,15,3,27,4,0,-18)
		val target = args(0).toInt
		try{
			println(twoSum(l,target))
			println(maximum(l))
		} catch {
			case NoSolutionException => println("No solution found. Sorry...")
		}
	}

	def twoSum(nums: List[Int], target: Int): List[Int] = {
		val myMap = Map[Int,Int]() //Fixed the state leak
		@tailrec
		def twoSum_helper(nums: List[Int], target: Int, index: Int = 0): List[Int] = {
			if(nums == Nil) throw NoSolutionException
			val ret = myMap.get(target - nums.head)
			ret match {
				case Some(ret) => List(ret, index)
				case None => myMap(nums.head) = index; twoSum_helper(nums.tail, target, index + 1)
			}
		}
		twoSum_helper(nums, target)
	}

	def maximum(nums: List[Int]) = {
		@tailrec
		def maximum_helper(nums: List[Int], currentMax: Int): Int = {
			nums match {
				case Nil => currentMax
				case _ if nums.head > currentMax => maximum_helper(nums.tail, nums.head)
				case _ => maximum_helper(nums.tail, currentMax)
			}
		}
		if(nums == Nil) throw NoSolutionException else maximum_helper(nums.tail, nums.head)
	}
}