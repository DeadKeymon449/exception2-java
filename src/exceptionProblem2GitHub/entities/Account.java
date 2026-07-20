package exceptionProblem2GitHub.entities;

import exceptionProblem2GitHub.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private double balance;
	private double withdrawLimit;

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {

		if (number == null || number <= 0) {
			throw new DomainException("Error: Account number must be positive.");
		}

		if (balance < 0) {
			throw new DomainException("Error: Initial balance cannot be negative.");
		}

		if (withdrawLimit <= 0) {
			throw new DomainException("Error: Withdraw limit must be greater than zero.");
		}

		this.number = number;
		setHolder(holder);
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public void setHolder(String holder) {
		
		if (holder == null || holder.trim().isEmpty()) {
			throw new DomainException("Holder name cannot be empty.");
		}

		holder = holder.trim();

		if (!holder.matches("[\\p{L} '-]+")) {
			throw new DomainException("Holder name must contain only letters.");
		}

		this.holder = holder;
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

		if (amount <= 0) {
			throw new DomainException("Deposit error: Deposit amount must be positive.");
		}

		balance += amount;
	}

	public void withdraw(double amount) {

		if (amount <= 0) {
			throw new DomainException("Withdraw error: Withdraw amount must be positive.");
		}

		if (amount > withdrawLimit) {
			throw new DomainException("Withdraw error: The amount exceeds withdraw limit.");
		}
		
		if (amount > balance) {
			throw new DomainException("Withdraw error: Not enough balance.");
		}

		balance -= amount;
	}

	@Override
	public String toString() {
		return "New balance: " + String.format("%.2f", balance);
	}

}
