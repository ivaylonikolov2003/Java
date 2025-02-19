public class Account {
    private double currentAmount = 0;

    public synchronized void setAmount(double amount){
        this.currentAmount = currentAmount + amount;
    }

    double getAmmount(){
        return currentAmount;
    }
}
