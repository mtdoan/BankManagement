package com.mtdoan.data;

public final class BankAccount {

  private final String number;
  private final String name;
  private double balance;

  public BankAccount(String number, String name) {
    this.number = number;
    this.name = name;
    balance = 0;
  }

  public double getBalance() {
    return balance;
  }

  public void withdraw(double money) {
    if (money < 0) {
      System.out.println("Invalid amount");
      return;
    }
    if (balance >= money) {
      balance -= money;
    } else {
      System.out.println("Your balance is not enough");
    }
  }

  public void deposit(double money) {
    if (money < 0) {
      System.out.println("Invalid amount");
      return;
    }
    balance += money;
  }
}
