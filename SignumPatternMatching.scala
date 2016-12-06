object SignumPatternMatching {

	def main(args: Array[String]) {
		val param1 = 5
		val param2 = -5
		val param3 = 0
		printf("%d\t%d\t%d\n", param1, signum1(param1), signum2(param1))
		printf("%d\t%d\t%d\n", param2, signum1(param2), signum2(param2))
		printf("%d\t%d\t%d\n", param3, signum1(param3), signum2(param3))
	}

	def signum1(value: Int) = {
		val ret = if(value > 0){
			1
		} else {
			if(value < 0){
               -1
            } else {
            	0
            }
		}
		ret
	}

	def signum2(value: Int) = {
		value match{
			case 0 => 0
			case _ if value > 0 => 1
			case _ => -1
		}
	}
}