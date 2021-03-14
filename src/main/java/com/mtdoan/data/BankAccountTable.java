package com.mtdoan.data;

import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public final class BankAccountTable {

  private final Map<String, BankAccount> table;

  public BankAccountTable() {
    table = new HashMap<>();
  }

  // @VisibleForTesting
  public int getTableSize() {
    return table.size();
  }

  public static BankAccountTable importFromScanner(Scanner scanner) {
    BankAccountTable bankAccountTable = new BankAccountTable();
    int noAccounts = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < noAccounts; ++i) {
      bankAccountTable.insertNewAccount(BankAccount.importFromScanner(scanner));
    }
    return bankAccountTable;
  }

  public String insertNewAccount(String accountName) {
    String accountNumber = UUID.randomUUID().toString();
    BankAccount newAccount = new BankAccount(accountNumber, accountName);
    table.put(accountNumber, newAccount);
    return accountNumber;
  }

  public String insertNewAccount(BankAccount bankAccount) {
    table.put(bankAccount.number, bankAccount);
    return bankAccount.number;
  }

  // @Nullable
  public BankAccount selectAccount(String accountNumber) {
    return table.get(accountNumber);
  }

  public void exportToWriter(PrintWriter outputWriter) {
    Collection<BankAccount> bankAccountList = table.values();
    outputWriter.println(bankAccountList.size());
    for (BankAccount bankAccount : bankAccountList) {
      bankAccount.exportToWriter(outputWriter);
    }
  }
}
