package com.mtdoan;

import com.mtdoan.data.BankAccount;
import com.mtdoan.data.BankAccountTable;
import java.util.Scanner;

public final class Main {

  private static void addNewUser(Scanner scanner, BankAccountTable bankAccountTable) {
    System.out.print("Account name: ");
    String accountName = scanner.nextLine();
    System.out.println("Your account number is: " + bankAccountTable.insertNewAccount(accountName));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BankAccountTable bankAccountTable = new BankAccountTable();
    while (true) {
      int functionId = scanner.nextInt();
      scanner.nextLine();
      switch (functionId) {
        case 1: // Add a new user
          System.out.println("Add a new user function.");
          addNewUser(scanner, bankAccountTable);
          break;
        case 2: // Check account balance
          System.out.println("CHECK ACCOUNT BALANCE FUNCTION");
          System.out.print("Account number: ");
          String accountNumber = scanner.nextLine();
          BankAccount userAccount = bankAccountTable.selectAccount(accountNumber);
          System.out.println("Your balance is : "+ userAccount.getBalance());
          break;
        case 3: // Withdraw from an account
          System.out.println("WITHDRAW FUNCTION");
          System.out.print("Account number: ");
          accountNumber = scanner.nextLine();
          userAccount = bankAccountTable.selectAccount(accountNumber);
          System.out.print("Withdraw amount: ");
          double money = scanner.nextDouble();
          userAccount.withdraw(money);
          System.out.println("Your balance is : "+ userAccount.getBalance());
          break;
        case 4: // Deposit to an account
          System.out.println("DEPOSIT FUNCTION");
          System.out.print("Account number: ");
          accountNumber = scanner.nextLine();
          userAccount = bankAccountTable.selectAccount(accountNumber);
          System.out.print("Deposit amount: ");
          money = scanner.nextDouble();
          userAccount.deposit(money);
          System.out.println("Your balance is : "+ userAccount.getBalance());
          break;
        case -1: // Save & Exit
          System.out.println("SAVED & EXIT");
          break;
        default:
          System.out.println("Invalid input: " + functionId);
      }
      if (functionId == -1) {
        break;
      }
    }
    scanner.close();
  }
}
