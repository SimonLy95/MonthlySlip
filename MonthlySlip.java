
// Made by Simon Ly.
/*
Assumptions made: 
Names must only be letters and hyphens.
Slips are generated for the entire month.
Users may want to repeat for more than one person.
*/
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MonthlySlip {
	public static void main(String[] args) {

		boolean runAgain = true;

		while (runAgain) {

			// Reads the user input.
			Scanner input = new Scanner(System.in);

			// Defining Variables.
			String firstName;
			String lastName;
			String paymentStartDate; // Can also use the date variable by importing java.util.date but we are using
										// string for simplicity sake.
			String payPeriod; // Can also be date variable
			String yesOrNo;
			int annualSalary = 0; // Can also be a double if cents are used.
			double tax;
			double grossIncome;
			double netIncome;
			double superRate = 0;
			double supe;
			boolean error = false; // For the do while try catch loop to stop errors from stopping the program.

			/*
			 * A GUI can also be created here with labels and text field for each required
			 * input. One button to calculate and another to quit. If an error occur a
			 * window can be used too.
			 */

			// Ask the user to enter their first name then save it.
			System.out.println("Please enter a first name: ");

			// Loops until the user enter letters and hyphens only into the first name.
			while (!Pattern.matches("[a-zA-Z-]+", firstName = input.nextLine())) {
				System.out.println("Please enter a valid first name!");
				System.out.println("Please enter a first name: ");
			}

			// Ask the user to enter their last name then save it.
			System.out.println("Please enter your last name: ");

			// Loops until the user enter letters and hyphens only into the last name.
			while (!Pattern.matches("[a-zA-Z-]+", lastName = input.nextLine())) {
				System.out.println("Please enter a valid last name!");
				System.out.println("Please enter a last name: ");
			}

			// Ask the user to enter their salary then save it.

			// A loop to only accept an integer above -1 and only integers.
			do {
				error = false;
				try {

					System.out.println("Please enter annual salary: ");
					// Loops until a value greater than -1 has been entered.
					// Use Math.round if a double is used.
					while ((annualSalary = input.nextInt()) < 0) {
						System.out.println("Please enter a positive integer!");
						System.out.println("Please enter your annual salary: ");
					}
				} catch (InputMismatchException e) {
					// Error message when wrong input is entered
					System.out.println("Please input an integer!");
					error = true;
					input.next();
				}

			} while (error);

			// Calculates the tax.
			if (annualSalary > 0 && annualSalary <= 18200)
				tax = 0;
			else if (annualSalary >= 18200 && annualSalary <= 37000)
				tax = ((annualSalary - 18200) * 0.19) / 12;
			else if (annualSalary >= 37001 && annualSalary <= 87000)
				tax = (3572 + (annualSalary - 37000) * 0.325) / 12;
			else if (annualSalary >= 87001 && annualSalary <= 180000)
				tax = (19822 + (annualSalary - 87000) * 0.37) / 12;
			else
				tax = (54232 + (annualSalary - 180000) * 0.45) / 12;

			// Calculates the gross income then the net income.
			grossIncome = annualSalary / 12;
			netIncome = grossIncome - tax;

			// Asks the user to input the super then calculate it.

			do {
				error = false;
				try {
					System.out.println("Please enter super rate (%):"); // Maybe can let a user put in a % symbol then
																		// remove it and parse it back as a double
					// Loop until the user enter a value between 0 and 50.
					while ((superRate = input.nextDouble()) < 0 || superRate > 50) {
						System.out.println("Please enter a value between 0 and 50 inclusive!");
						System.out.println("Please enter super rate:");
					}
				} catch (InputMismatchException e) {
					System.out.println("Please only enter numbers!");
					error = true;
					input.next();
				}
			} while (error);

			supe = grossIncome * (superRate / 100);

			// Asks the user to input the date.
			// Can also use a function to ask the starting date and then the ending date and
			// also use a loop to only accept dates.
			System.out.println("Please enter payment start date, please enter a month e.g (JAN or December): "); 
			input.nextLine(); // consumes the next line
			paymentStartDate = input.nextLine();

			// Switch can be used but switch case requires a constant expression
			/*
			 * switch (paymentStartDate) { case "January" : payPeriod =
			 * "01 January - 31 January"; break; case "December" : payPeriod =
			 * "01 December - 31 Dec"; break; default: payPeriod = paymentStartDate; break;
			 */
			// A loop could be made to accept only certain values.
			/*
			 * This logic will fail if user types 2nd of jan, another condition can be used
			 * is: if(paymentStartDate == "jan" || paymentStartDate == "january") but the
			 * assumption is made that the user would want to generate the payment slip for
			 * the entire month.
			 */
			if (paymentStartDate.toLowerCase().contains("jan")) {
				payPeriod = "01 January - 31 January"; // Date can also be used
			} else if (paymentStartDate.toLowerCase().contains("feb")) { 
				payPeriod = "01 Febuary - 28 Febuary";
			} else if (paymentStartDate.toLowerCase().contains("mar")) {
				payPeriod = "01 March - 31 March";
			} else if (paymentStartDate.toLowerCase().contains("apr")) {
				payPeriod = "01 April - 30 April";
			} else if (paymentStartDate.toLowerCase().contains("may")) {
				payPeriod = "01 May - 31 May";
			} else if (paymentStartDate.toLowerCase().contains("jun")) {
				payPeriod = "01 June - 30 June";
			} else if (paymentStartDate.toLowerCase().contains("jul")) {
				payPeriod = "01 July - 31 July";
			} else if (paymentStartDate.toLowerCase().contains("aug")) {
				payPeriod = "01 August - 31 August";
			} else if (paymentStartDate.toLowerCase().contains("sep")) {
				payPeriod = "01 September - 30 September";
			} else if (paymentStartDate.toLowerCase().contains("oct")) {
				payPeriod = "01 October - 31 October";
			} else if (paymentStartDate.toLowerCase().contains("nov")) {
				payPeriod = "01 November - 30 November";
			} else if (paymentStartDate.toLowerCase().contains("dec")) {
				payPeriod = "01 December - 31 December";
			} else {
				payPeriod = paymentStartDate; // In case of special cases like 01/01/21 - 15/01/21, Monday ... etc
			}

			// Prints out all the entered and calculated value.
			System.out.println("Full Name: " + firstName + " " + lastName + ", Pay period: " + payPeriod
					+ ", Gross Income: $" + Math.round(grossIncome) + ", Income Tax: $" + Math.round(tax)
					+ ", Net Income: $" + Math.round(netIncome) + ", Super: $" + Math.round(supe) + "." + "\n");

			/*
			 * Data can be stored into a database using JSON. "Employees:" { { "First Name"
			 * : firstName, ... "Super: $" : supe } }
			 */
			// Loops if user types YES, Y or Yes, exits the loop if user types no, exit,
			// quit ... etc. The user could also just exit the window.
			// Loop can be made to only accept yes or no.
			System.out.print("Would you like to generate another monthly slip? y/n?");
			yesOrNo = input.nextLine();
			if (yesOrNo.toLowerCase().contains("y")) {
				runAgain = true;
			} else {
				runAgain = false;
			}
		}

	}
}
