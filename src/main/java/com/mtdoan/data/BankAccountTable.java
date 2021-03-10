package com.mtdoan.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class BankAccountTable {
  private final Map<String, BankAccount> table;

  public BankAccountTable() {
    table = new HashMap<>();
  }

  public String insertNewAccount(String accountName) {
    String accountNumber = UUID.randomUUID().toString();
    BankAccount newAccount = new BankAccount(accountNumber, accountName);
    table.put(accountNumber, newAccount);
    return accountNumber;
  }

  public BankAccount selectAccount(String accountNumber) {
    return table.get(accountNumber);
  }
}
