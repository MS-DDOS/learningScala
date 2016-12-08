case class InvalidTimeException(message: String = "") extends Exception{}

class Time(h: Int, m: Int){
	private var minutes = 0

	def hours = {minutes / 60}
	def mins = {minutes % 60}
	def before(other: Time) = {minutes < other.minutes}

	if(h > 23 || h < 0) throw InvalidTimeException("Hours field must have a value between 0 and 23!")
	if(m > 60 || m < 0) throw InvalidTimeException("Minutes field must have a value between 0 and 60!")
	minutes = Time.flattenToMinutes(h, m)
}

object Time {
	def flattenToMinutes(hours: Int, mins: Int) = {60 * hours + mins}
	def main(args: Array[String]) {
		try{ 
			val t1 = new Time(1,20)
			val t2 = new Time(4,50)
			printf("Time 1: %d:%d < Time 2: %d:%d = %b\n", t1.hours, t1.mins, t2.hours, t2.mins, t1.before(t2))
			printf("Time 1: %d:%d > Time 2: %d:%d = %b\n", t1.hours, t1.mins, t2.hours, t2.mins, t2.before(t1))
			val invalid = new Time(24,0)
			} catch {
				case e: InvalidTimeException => println(e.message)
			}
	}
}