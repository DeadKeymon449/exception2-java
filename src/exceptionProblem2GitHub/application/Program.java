package exceptionProblem2GitHub.application;

import java.util.Locale;
import java.util.Scanner;

import exceptionProblem2GitHub.entities.Account;

public class Program {

	public static void main(String[] arguments) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

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

		if (amountToWithdraw > account.getWithdrawLimit()) {
			System.out.println("Withdraw error: The amount exceeds withdraw limit.");
		} else {
			if (amountToWithdraw > account.getBalance()) {
				System.out.println("Withdraw error: Not enough balance.");
			} else {
				account.withdraw(amountToWithdraw);
				System.out.println(account);
			}
		}

		sc.close();
	}

}
