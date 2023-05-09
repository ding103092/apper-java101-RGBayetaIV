package accessmodifiers;

import accessmodifiers.financial.Balance;

public class Account {
    void displayBalance() {
        Balance balance = new Balance();
        balance.amount = 101;

        System.out.println(balance.getBalance());
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.displayBalance();
    }
}
