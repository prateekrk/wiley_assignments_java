package banking;

import com.prateek.Main;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

public class Operations {

    void credit(Account a,int c){
        double balance= a.getBalance();
        Transactions t=new Transactions(a,"credit : ",c,new Denominations((int)c/50,0));
        a.transactions.add(t);
        a.setBalance( balance+c);
        MainClass.transactionMap.put(a,a.transactions);
    }
    void debit(Account a, int d,double balance){
        int d1=d;
        int deno50=0;
        int deno10=0;
        if(d1%100!=0){
            System.out.println("Sorry we don't have denominations available to full fill ");
            return;
        }
        if(d>(MainClass.arr[0]*50+MainClass.arr[1]*10)){
            System.out.println("Sorry!");
            return;
        }
        if(balance<d){
            System.out.println("Insufficient Balance");
            return;
        }
        if(d<=(MainClass.arr[0]*50) && MainClass.arr[0]!=0){
            deno50=(int )d/ 50;
            MainClass.arr[0]-=deno50;
            d-=deno50*50;
        }
        else if(d!=0 && MainClass.arr[1]!=0 && d<=(MainClass.arr[1]*10)){
            deno10=(int) d/10;
            MainClass.arr[1]-=deno10;
            d-=deno10*10;

        }
            Transactions t = new Transactions(a, "debit : ", d1, new Denominations(deno50, deno10));
            a.setBalance(balance - d);
            a.transactions.add(t);



    }

}
