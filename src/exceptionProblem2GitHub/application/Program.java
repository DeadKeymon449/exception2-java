package exceptionProblem2GitHub.application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import exceptionProblem2GitHub.entities.Account;
import exceptionProblem2GitHub.exceptions.DomainException;

public class Program {

	public static void main(String[] arguments) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Enter account data\n");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();

			Account account = new Account(number, holder, balance, withdrawLimit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");

			double amountToWithdraw = sc.nextDouble();

			account.withdraw(amountToWithdraw);

			System.out.println(account);
		} catch (InputMismatchException e) {
			System.out.println("Invalid digit.");
		} catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		} finally {			
			sc.close();
		}
	}

}
