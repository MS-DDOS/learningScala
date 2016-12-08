case class InsufficientFundsException(message: String) extends Exception{}

class BankAccount(private var accountBalance: Double = 0.0) {
	def balance = accountBalance
	def deposit(amt: Double = 0.0) = {accountBalance += amt}
	def withdraw(amt: Double = 0.0) = {
		if(amt <= accountBalance) 
			accountBalance -= amt 
		else 
			throw InsufficientFundsException("Your account has insufficient funds ($" + this.balance + ") for a withdrawal of $" + amt)
	}
}

object BankAccount {

	def main(args: Array[String]) {
		val acct = new BankAccount()
		try {
			acct.deposit(500.00)
			acct.deposit(100.00)
			acct.withdraw(150.00)
			acct.withdraw(500.00)
		} catch {
			case e: InsufficientFundsException => println(e.message)
		}

	}

}