package exceptionProblem2GitHub.entities;

import exceptionProblem2GitHub.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {

		if (amount > getWithdrawLimit()) {
			throw new DomainException("The amount exceeds withdraw limit.");
		}

		if (amount > getBalance()) {
			throw new DomainException("Not enough balance.");
		}

		balance -= amount;
	}

	@Override
	public String toString() {
		return "New balance: " + String.format("%.2f", balance);
	}

}
