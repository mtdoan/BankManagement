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
}
