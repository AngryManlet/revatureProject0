// Scala program for a simple banking application
// readline import
import scala.io.StdIn._
// Creating object
object simpleBank
{
	//variables storing starting values
	var userName: String = "user1"
	var passWord: String = "password1"
	var accountMoney: Double = 1000.00
	var accountStatus: String = "Normal"
	var action: String = ""
	// Method for depositing money
	def deposit(x:Double) : Double = 
	{
		print("Enter your deposit amount: ")
		var depositAmount = readDouble()
		var netAmount = x + depositAmount
		return netAmount
	} 
	//Method for withdrawing money, asking again if money to be withdrawn is greater than money in account
	def withdraw(x:Double) : Double =
	{
		print("Enter your withdrawal amount: ")
		var withdrawAmount = readDouble()
		if (withdrawAmount > accountMoney)
			{
				println("Insufficient Funds.")
				withdraw(accountMoney)
			}
		else
			{
				var netAmount = x - withdrawAmount
				return netAmount
			}
		
	}
	// Main method, asks for username and password, runs again if wrong username and password, and asks for actions to take, ends if asked
	def main(args: Array[String])
	{
		println("Please enter your username and password: ")
		println("username: ")
		var enteredUserName = readLine()
		println("password: ")
		var enteredPassword = readLine()
		if (enteredUserName == userName || enteredPassword == passWord){
		do{
			println("How may we help you today? ")
			action = readLine("Please enter deposit, withdraw, or end ")
			if (action == "deposit")
				{
					accountMoney = deposit(accountMoney)
				}
			else if (action == "withdraw")
				{
					accountMoney = withdraw(accountMoney)
				}
			else if (action == "end")
				{
					println("Thank you, have a good day!")
				}
			else
				{
					println("Please try again.")
				}
			if (accountMoney > 1000000)
				{
					accountStatus = "Gold"
				}
			else 
				{
					accountStatus = "Normal"
				}
			println("Money in account: " + accountMoney)
			println("Account Status: " + accountStatus)
		}
		while (action != "end")}
		else
			{
				println("Incorrect username or password. Please try again.")
				main(args)
			}
	}
}
