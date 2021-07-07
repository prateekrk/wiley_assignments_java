package banking;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

public class MainClass {
    static List<Transactions> transactions=new ArrayList<>();
    public static void main(String args[]){

        Map<Integer,Double> accounts=new HashMap<>();

        Map<Integer,List<Transactions>> details=new HashMap<>();
        Account a1=new Account(13245);
        a1.setBalance(2000.00);
        Account a2=new Account(12304);
        a2.setBalance(4000.00);
        Account a3=new Account(15573);
        a3.setBalance(5000.00);
        Account a4=new Account(14542);
        a4.setBalance(9000);

        accounts.put(a1.getAcId(),a1.getBalance());
        accounts.put(a2.getAcId(),a2.getBalance());
        accounts.put(a3.getAcId(),a3.getBalance());
        accounts.put(a4.getAcId(),a4.getBalance());

        //a1 transactions
        accounts.put(13245,new Operations().credit(13245,10000.00,accounts.get(a1.getAcId())));
        accounts.put(13245,new Operations().debit(13245,5000,accounts.get(a1.getAcId())));


        //a2 transactions
        accounts.put(12304,new Operations().credit(12304,500.00,accounts.get(a1.getAcId())));
        accounts.put(12304,new Operations().debit(12304,2000,accounts.get(a1.getAcId())));



        transactions.stream()
                .filter(transactions1 -> transactions1.getAcId()==a1.getAcId())
                .forEach(t->System.out.println(t.toString()));

    }
}
