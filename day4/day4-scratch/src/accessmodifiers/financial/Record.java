package accessmodifiers.financial;

public class Record {
    void displayBalance() {
        Balance balance = new Balance();
        balance.amount = 100;

        System.out.println(balance.amount);
    }

    public static void main(String[] args) {
        Record record = new Record();
        record.displayBalance();
    }
}
