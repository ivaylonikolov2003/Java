public class ClientThread implements Runnable{
    private double amount;
    private Account account;

    public ClientThread(Account account, double amount) {
        this.amount = amount;
        this.account = account;
    }

    @Override
    public void run() {
        account.setAmount(amount);
    }
}
