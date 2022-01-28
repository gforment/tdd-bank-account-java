package org.xpdojo.bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.xpdojo.bank.Account.emptyAccount;

public class AccountTest {

    @Test
    public void initialAccount_ZeroBalance() {
        Account account=emptyAccount();
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void depositSingleAmount() {
        Account account=emptyAccount();
        account.deposit(20);
        assertThat(account.balance()).isEqualTo(20);
    }

    @Test
    public void depositMultipleAmount() {
        Account account=emptyAccount();
        account.deposit(20);
        account.deposit(30);
        assertThat(account.balance()).isEqualTo(50);
    }

    @Test
    public void withdrawSingleAmount() {
        Account account=emptyAccount();
        account.deposit(50);
        try {
            account.withdraw(10);
        } catch (NoFundException e) {
            e.printStackTrace();
        }
        assertThat(account.balance()).isEqualTo(40);
    }

    @Test
    public void withdrawMultipleAmount() {
        Account account=emptyAccount();
        account.deposit(50);
        try {
            account.withdraw(10);
            account.withdraw(20);
        } catch (NoFundException e) {
            e.printStackTrace();
        }
        assertThat(account.balance()).isEqualTo(20);
    }

    @Test
    public void withdrawWithoutFunds() {
        Account account=emptyAccount();
        Assertions.assertThatCode(() -> account.withdraw(10)).isInstanceOf(NoFundException.class);
    }
}
