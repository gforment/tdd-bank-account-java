package org.xpdojo.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

}
