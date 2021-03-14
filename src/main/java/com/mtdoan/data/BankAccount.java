package com.mtdoan.data;

import java.io.PrintWriter;
import java.util.Scanner;

public final class BankAccount {

  final String number;
  final String name;
  double balance;

  public BankAccount(String number, String name) {
    this.number = number;
    this.name = name;
    balance = 0;
  }

  public BankAccount(String number, String name, double balance) {
    this.number = number;
    this.name = name;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public String getName() {
    return name;
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


  public static BankAccount importFromScanner(Scanner scanner) {
    String number = scanner.nextLine();
    String name = scanner.nextLine();
    double balance = scanner.nextDouble();
    scanner.nextLine();
    return new BankAccount(number, name, balance);
  }

  public void exportToWriter(PrintWriter outputWriter) {
    outputWriter.println(number);
    outputWriter.println(name);
    outputWriter.println(balance);
  }
}
