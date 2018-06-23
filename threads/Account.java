package threads;

public class Account {
    private String name;
    private int accountNumber;
    private int amount;

    public Account(String name, int accountNumber, int amount) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}