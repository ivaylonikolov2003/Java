import java.io.Serializable;

public class Account implements Serializable {
    private String id;
    private String name;
    private int balance;

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount){
        this.balance += amount;
        return balance;
    }

    public int debit(int amount){
        if (amount <= balance) {
            balance -= amount;
        }else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    public int transferTo(Account account, int amount){
        if (amount <= balance){
            this.balance -= amount;
            account.balance += amount;
        }
        else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }

    @Override
    public String toString() {
        return String.format("Account[id= %s, name= %s, balance= %d]", this.id, this.name, this.balance);
    }
}
