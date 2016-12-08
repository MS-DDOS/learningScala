class Time(val hours: Int, val mins: Int){
	def before(other: Time) = {Time.flattenToMinutes(this) < Time.flattenToMinutes(other)}
}

object Time {
	def flattenToMinutes(composite: Time) = {60 * composite.hours + composite.mins}
	def main(args: Array[String]) {
		val t1 = new Time(1,20)
		val t2 = new Time(4,50)
		printf("Time 1: %d:%d < Time 2: %d:%d = %b\n", t1.hours, t1.mins, t2.hours, t2.mins, t1.before(t2))
		printf("Time 1: %d:%d > Time 2: %d:%d = %b\n", t1.hours, t1.mins, t2.hours, t2.mins, t2.before(t1))
	}
}