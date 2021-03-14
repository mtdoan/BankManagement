package com.mtdoan;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mtdoan.data.BankAccount;
import com.mtdoan.data.BankAccountTable;
import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  public void testAddUserNameWithoutSpaces() {
    // Initialization
    BankAccountTable bankAccountTable = new BankAccountTable();
    String accountName = "Thuy";

    // Action
    String accountNumber = Main.addNewUser(accountName, bankAccountTable);

    // Assertion
    assertEquals(1, bankAccountTable.getTableSize());
    BankAccount bankAccount = bankAccountTable.selectAccount(accountNumber);
    assertEquals(true, bankAccount != null);
    assertEquals(accountName, bankAccount.getName());
  }

  @Test
  public void testAddUserNameWithSpaces() {
    assertEquals(0, 1);
  }

  @Test
  public void testAddUserNameExisted() {
    assertEquals(0, 1);
  }
}
