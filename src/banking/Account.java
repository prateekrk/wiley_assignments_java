package banking;

public class Account {
    int acId;
    double balance;

    Account(int acId){
        this.acId=acId;
    }
    public double getBalance() {
        return balance;
    }

    public int getAcId() {
        return acId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
