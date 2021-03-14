package com.mtdoan;

import com.mtdoan.data.BankAccount;
import com.mtdoan.data.BankAccountTable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class Main {

  public static final String BANK_FILE_TXT = "/home/mtdoan/CodeThongMinh/BankFile.txt";

  private static String inputAccountNumber(Scanner scanner) {
    System.out.print("Account number: ");
    return scanner.nextLine();
  }

  private static void addNewUser(Scanner scanner, BankAccountTable bankAccountTable) {
    System.out.print("Account name: ");
    String accountName = scanner.nextLine();
    System.out.println("Your account number is: " + addNewUser(accountName, bankAccountTable));
  }

  // @VisibleForTesting
  static String addNewUser(String accountName, BankAccountTable bankAccountTable) {
    return bankAccountTable.insertNewAccount(accountName);
  }

  private static void showAccountBalance(Scanner scanner, BankAccountTable bankAccountTable) {
    String accountNumber = inputAccountNumber(scanner);
    showAccountBalance(accountNumber, bankAccountTable);
  }

  private static void showAccountBalance(String accountNumber, BankAccountTable bankAccountTable) {
    BankAccount userAccount = bankAccountTable.selectAccount(accountNumber);
    System.out.println("Your balance is : " + userAccount.getBalance());
  }

  private static void withdraw(Scanner scanner, BankAccountTable bankAccountTable) {
    String accountNumber = inputAccountNumber(scanner);
    BankAccount userAccount = bankAccountTable.selectAccount(accountNumber);
    System.out.print("Withdraw amount: ");
    double withdrawAmount = scanner.nextDouble();
    userAccount.withdraw(withdrawAmount);
    showAccountBalance(accountNumber, bankAccountTable);
  }

  private static void deposit(Scanner scanner, BankAccountTable bankAccountTable) {
    String accountNumber = inputAccountNumber(scanner);
    BankAccount userAccount = bankAccountTable.selectAccount(accountNumber);
    System.out.print("Deposit amount: ");
    double depositAmount = scanner.nextDouble();
    userAccount.deposit(depositAmount);
    showAccountBalance(accountNumber, bankAccountTable);
  }

  public static void exportToFile(BankAccountTable bankAccountTable) {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(
        BANK_FILE_TXT);
      PrintWriter writer = new PrintWriter(fileOutputStream);
      bankAccountTable.exportToWriter(writer);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static BankAccountTable importFromFile() {
    File bankFile = new File(BANK_FILE_TXT);
    if (!bankFile.exists()) {
      return new BankAccountTable();
    }
    try {
      FileInputStream fileInputStream = new FileInputStream(bankFile);
      try (Scanner scanner = new Scanner(fileInputStream)) {
        return BankAccountTable.importFromScanner(scanner);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return new BankAccountTable();
    }
  }

  public static void main(String[] args) {
    BankAccountTable bankAccountTable = importFromFile();
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.print("CHOOSE A FUNCTION: ");
      int functionId = scanner.nextInt();
      scanner.nextLine();
      switch (functionId) {
        case 1: // Add a new user
          System.out.println("ADD A NEW USER FUNCTION");
          addNewUser(scanner, bankAccountTable);
          break;
        case 2: // Check account balance
          System.out.println("CHECK ACCOUNT BALANCE FUNCTION");
          showAccountBalance(scanner, bankAccountTable);
          break;
        case 3: // Withdraw from an account
          System.out.println("WITHDRAW FUNCTION");
          withdraw(scanner, bankAccountTable);
          break;
        case 4: // Deposit to an account
          System.out.println("DEPOSIT FUNCTION");
          deposit(scanner, bankAccountTable);
          break;
        case -1: // Save & Exit
          System.out.println("SAVING & EXITING");
          exportToFile(bankAccountTable);
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