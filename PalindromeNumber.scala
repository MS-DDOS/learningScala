import scala.annotation.tailrec

object PalindromeNumber {

	def main(args: Array[String]) {
		val testSuite = Array[Long](0L, -0L, 1221L, -1221L, 12321L, 12221L, 123421L, 12345L, 9223372036854775807L, -9223372036854775808L, 1111222222222221111L, -1111222222222221111L)
		for(test <- testSuite)
			printf("%d => %b%n", test, isPalindrome(test))
	}

	def isPalindrome(number: Long) = {
		val numberAsString = math.abs(number).toString
		@tailrec
		def checkPalindrome(firstIndex: Int, lastIndex: Int): Boolean = {
			if(firstIndex == lastIndex) numberAsString(firstIndex) == numberAsString(lastIndex)
			else if(lastIndex < firstIndex) true
			else if(numberAsString(firstIndex) == numberAsString(lastIndex)) checkPalindrome(firstIndex + 1, lastIndex - 1)
			else false
		}
		checkPalindrome(0, numberAsString.length - 1)
	}

}