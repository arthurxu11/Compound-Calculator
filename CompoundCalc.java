import java.math.BigDecimal;
import java.util.*;

// Arthur Xu
// Feb 9th, 2020
// Compound Interest Calculator
// Calculations may be slightly off, due to the fact you can't do exponents with BigDecimal, only doubles. 

public class CompoundCalc {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		print("Welcome to the financial calculator!");

		
		boolean doing = true;
		while (doing = true) {
			// Gets user selection and chooses which formula to use
			print("What are you looking to solve today? (Enter the corresponding number)");
			print("");
			print("1) Future value of current investment with compound interest");
			print("2) Future value of current investment with monthly deposits with compound interest");
			print("3) Current deposit needed to reach future value, compound interest");
			print("4) Regular deposits needed to reach future value, compound interest");			int choice = sc.nextInt();
			if (choice == 1) {
				doOne();
			} else if (choice == 2) {
				doTwo();
			} else if (choice == 3) {
				doThree();
			} else if (choice == 4) {
				doFour();
			} else {
				print("Invalid input!");
			}
		}
	}
	
	private static void doFour() {
		
		print("");
		Scanner sc = new Scanner(System.in);
		
		// Gets user information
		print("How much money would you like to have? (Leave out dollar signs)");
		int deposit = sc.nextInt();
		print("What is the compound interest rate? (Leave out percent sign)");
		int n = sc.nextInt();
		float rate = n/100.0f;
		print("How many times is the money compounded per year? (Yearly = 1, Monthly = 12, ...");
		int times = sc.nextInt();
		print("How soon would you like to reach the amount, in years?");
		int years = sc.nextInt();
		
		//Does the calculations
		float top = deposit*rate;
		double bottom = Math.pow(1+rate/times, years/times) - 1;
		double total = top/bottom;
		total = Math.round(total/100.00)*100.00;
		// Outputs results
		print("To have $"+deposit+" in "+years+" years, you must deposit $"+total+" annually!");
		print("");
		
		// Asks user if they want to continue
		print("Would you like to calculate again? (Y/N)");
		String response = sc.next();
		if (response.equals("N") == true) {
			print("Thank you for using this software! See you soon!");
			System.exit(0);
		}
	}

	private static void doThree() {
		
		print("");
		Scanner sc = new Scanner(System.in);

		// Gets user information
		print("How much money would you like to have? (Leave out dollar signs)");
		float deposit = sc.nextInt();
		print("What is the compound interest rate? (Leave out percent sign)");
		float n = sc.nextInt();
		float rate = n/100.0f;
		print("How many times is the money compounded per year? (Yearly = 1, Monthly = 12, ...");
		float times = sc.nextInt();
		print("How soon would you like to reach the amount, in years?");
		int years = sc.nextInt();
		
		// Calculates
		float interest = 1+ rate/times;
		double x = Math.pow(interest, (years*times*-1));
		double total = deposit * x;
		total = Math.round(total*100.00)/100.00;
		//Outputs results
		print("To have $"+deposit+" in "+years+" years, you would have to deposit $"+total+" now!");
		print("");
		
		// Asks user if they would like to continue
		print("Would you like to calculate again? (Y/N)");
		String response = sc.next();
		if (response.equals("N") == true) {
			print("Thank you for using this software! See you soon!");
			System.exit(0);
		}
	}

	public static void doTwo() {
		print("");
		Scanner sc = new Scanner(System.in);
		
		// Gets user information
		print("What is the value of the current deposit? (Leave out dollar signs)");
		float mainDeposit = sc.nextInt();
		print("What is the continuous deposit amount? (Leave out dollar signs");
		float contDeposit = sc.nextInt();
		print("How many deposits will you make per year?");
		float contDepTime = sc.nextInt();
		print("What is the compound interest rate? (Leave out percent sign)");
		float n = sc.nextInt();
		float rate = n/100.0f;
		print("How many times is the money compounded per year? (Yearly = 1, Monthly = 12, ...");
		float times = sc.nextInt();
		print("How many years will the money be left?");
		int years = sc.nextInt();
		
		// Main Deposit
		float interest = rate/times;
		float base = (1 + interest);
		double amount = Math.pow(base, years*times);
		double mainTotal = amount*mainDeposit;
		
		// Continuous deposits
		double contTotal = (1+ rate/contDepTime);
		contTotal = Math.pow(contTotal, years*contDepTime);
		contTotal -= 1;
		contTotal *= contDeposit;
		contTotal /= rate/contDepTime;
		
		// Sums the main and continuous deposits and outputs
		double total = mainTotal + contTotal;
		total = Math.round(total*100.00)/100.00;
		print("After "+years+" years, your initial deposit of $"+mainDeposit+" will become $"+total+"!");
		print("");
		
		// Asks if user would like to continue
		print("Would you like to calculate again? (Y/N)");
		String response = sc.next();
		if (response.equals("N") == true) {
			print("Thank you for using this software! See you soon!");
			System.exit(0);
		}
		
	}

	public static void doOne() {
		
		print("");
		Scanner sc = new Scanner(System.in);
		
		// Gets user information
		print("What is the current value of the deposit? (Leave out dollar signs)");
		float deposit = sc.nextInt();
		print("What is the compound interest rate? (Leave out percent sign)");
		float n = sc.nextInt();
		float rate = n/100.0f;
		print("How many times is the money compounded per year? (Yearly = 1, Monthly = 12, ...");
		float times = sc.nextInt();
		print("How many years will the money be left?");
		float years = sc.nextInt();
		
		// Calculation of interest
		float interest = rate/times;
		float base = (1 + interest);
		double amount = Math.pow(base, years*times);
		double total = amount*deposit;
		total = Math.round(total*100.00)/100.00;
		// Outputs result
		print("After "+years+" years, your initial deposit of $"+deposit+" will become $"+total+"!");
		print("");
		
		// Asks if the user would like to continue
		print("Would you like to calculate again? (Y/N)");
		String response = sc.next();
		if (response.equals("N") == true) {
			print("Thank you for using this software! See you soon!");
			System.exit(0);
		}
		
	}

	public static void print(String phrase) {
		
		// Outputs items
		System.out.println(phrase);
	}

}

