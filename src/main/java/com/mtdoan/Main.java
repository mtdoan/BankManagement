package com.mtdoan;

import java.util.Scanner;

public final class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      int functionId = scanner.nextInt();
      switch (functionId) {
        case 1: // Add a new user
          break;
        case 2: // Check account balance
          break;
        case 3: // Withdraw from an account
          break;
        case 4: // Deposit to an account
          break;
        case -1: // Save & Exit
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
