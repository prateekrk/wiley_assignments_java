package banking;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int acId;
    private double balance;
    private Customer c;
    List<Transactions> transactions=new ArrayList<>();
    Account(Customer c,int acId){
        this.c=c;
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



    public Customer getC() {
        return c;
    }

    @Override
    public String toString() {
        return "CustID : "+c+" AccId : "+acId+" Balance : "+balance;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }
}
