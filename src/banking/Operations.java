package banking;

import com.prateek.Main;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

public class Operations {
    int deno50=0;
    int deno10=0;
    void credit(Account a,int c){
        double balance= a.getBalance();
        Transactions t=new Transactions(a,"credit : ",c,new Denominations((int)c/50,0));
        a.transactions.add(t);
        a.setBalance( balance+c);
        MainClass.transactionMap.put(a,a.transactions);
    }
    void debit(Account a, int d,double balance){

        if(d%100!=0){

            System.out.println("Account id "+a.getAcId()+" Rs."+d+" Sorry we don't have denominations available to full fill ");
            return;
        }
        if(balance<d){
            System.out.println("Insufficient Balance");
            return;
        }
            Transactions t = new Transactions(a, "debit : ", d,selectDenominations(d));
            a.setBalance(balance - d);
            a.transactions.add(t);



    }

    Denominations selectDenominations(int d){
        int d1=d;

        if(d>(MainClass.arr[0]*50+MainClass.arr[1]*10)){
            System.out.println("Sorry!");
            return new Denominations(0,0);
        }
        if(d<=(MainClass.arr[0]*50) && MainClass.arr[0]!=0){
            deno50=(int )d/ 50;
            MainClass.arr[0]-=deno50;
            d-=deno50*50;
        }
        else if(d>MainClass.arr[0]*50){
            deno50=MainClass.arr[0];
            MainClass.arr[0]=0;
            d-=deno50*50;
        }
        if(d!=0 && MainClass.arr[1]!=0 && d<=(MainClass.arr[1]*10)){
            deno10=(int) d/10;
            MainClass.arr[1]-=deno10;
            d-=deno10*10;
        }
        return  new Denominations(deno50,deno10);
    }
}
