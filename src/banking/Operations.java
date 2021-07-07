package banking;

import java.util.ArrayList;
import java.util.List;

public class Operations {

    double credit(int acid,double c,double balance){
        balance= c+balance;
        Transactions t=new Transactions(acid,"credit",balance);
        MainClass.transactions.add(t);
        return balance;


    }
    double debit(int acid,double d,double balance){
        balance= balance-d;
        Transactions t=new Transactions(acid,"credit",balance);
        MainClass.transactions.add(t);
        return balance;
    }



}
