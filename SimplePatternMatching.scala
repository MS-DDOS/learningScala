import math._
object SimplePatternMatch {

	def main(args: Array[String]) {
		printf("%.2f\t%.2f\n",foo(2,2),bar(2,2))
		printf("%.2f\t%.2f\n",foo(2,3),bar(2,3))
		printf("%.2f\t%.2f\n",foo(2,0),bar(2,0))
		printf("%.2f\t%.2f\n",foo(2,-1),bar(2,-1))
	}

	def foo(x: Double, n: Int): Double = {
		if(n == 0){
			1 
		} else {
			if(n > 0) {
				if( n % 2 == 0) {
					pow(pow(x, n/2), 2)
				} else {
					x * pow(x, n-1)
				}
			} else {
				1 / pow(x, -n)
			}
		}
	}

	def bar(x: Double, n: Int): Double = {
		x match{
			case 0 => 1
			case _ if n > 0 && n % 2 == 0 => pow(pow(x, n/2), 2)
			case _ if n > 0 => x * pow(x, n-1)
			case _ => 1 / pow(x, -n)
		}
	}
}