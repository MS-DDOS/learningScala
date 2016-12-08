case class InvalidTimeException(message: String = "") extends Exception{}

class Time{
	private var minutes = 0
	def this(hours: Int, mins: Int) = {
		this()
		if(hours > 23 || hours < 0) throw InvalidTimeException("Hours field must have a value between 0 and 23!")
		if(minutes > 60 || minutes < 0) throw InvalidTimeException("Minutes field must have a value between 0 and 60!")
		minutes = Time.flattenToMinutes(hours, mins)
	}
	def hours = {minutes / 60}
	def mins = {minutes % 60}
	def before(other: Time) = {minutes < other.minutes}
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