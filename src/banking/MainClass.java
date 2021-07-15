package banking;

import com.sun.corba.se.spi.orb.Operation;

import java.util.*;

public class MainClass {
    static int arr[]={100,100};
    static Map<Account,List<Transactions>> transactionMap=new TreeMap<Account, List<Transactions>>(Comparator.comparing(Account::getAcId));
    static List<Transactions> transactions=new ArrayList<>();
    public static void main(String args[]){

//        Map<Integer,Double> accounts=new HashMap<>();
//
//        Map<Integer,List<Transactions>> details=new HashMap<>();
//        Account a1=new Account(13245);
//        a1.setBalance(2000.00);
//        Account a2=new Account(12304);
//        a2.setBalance(4000.00);
//        Account a3=new Account(15573);
//        a3.setBalance(5000.00);
//        Account a4=new Account(14542);
//        a4.setBalance(9000);
//
//        accounts.put(a1.getAcId(),a1.getBalance());
//        accounts.put(a2.getAcId(),a2.getBalance());
//        accounts.put(a3.getAcId(),a3.getBalance());
//        accounts.put(a4.getAcId(),a4.getBalance());
//
//        //a1 transactions
//        accounts.put(13245,new Operations().credit(13245,10000.00,accounts.get(a1.getAcId())));
//        accounts.put(13245,new Operations().debit(13245,5000,accounts.get(a1.getAcId())));
//
//
//        //a2 transactions
//        accounts.put(12304,new Operations().credit(12304,500.00,accounts.get(a1.getAcId())));
//        accounts.put(12304,new Operations().debit(12304,2000,accounts.get(a1.getAcId())));
//
//
//        for(Integer i:accounts.keySet()) {
//            System.out.println("----------History of "+i+"-----------");
//            transactions.stream()
//                    .filter(transactions1 -> transactions1.getAcId() == i)
//                    .forEach(transactions1 -> System.out.println(transactions1.toString()));
//        }


        Customer c1=new Customer(1);
        Customer c2=new Customer(2);

        Account a1=new Account(c1,11);
        a1.setBalance(50000);
        Account a2=new Account(c1,12);
        a2.setBalance(60000);
        Account a3=new Account(c1,13);
        a3.setBalance(5000);
        Account a4=new Account(c2,21);
        a4.setBalance(8000);

        c1.accounts.add(a1);
        c1.accounts.add(a2);
        c1.accounts.add(a3);
        c2.accounts.add(a4);

        List<Customer> customers=Arrays.asList(c1,c2);

        customers.stream().forEach(customer -> customer.getAccounts().stream().forEach(System.out::println));


        Operations o=new Operations();

        o.credit(a1,5000);
        o.debit(a1,5100,a1.getBalance());
        o.credit(a2,6000);
        o.debit(a2,900,a2.getBalance());
        o.debit(a2,5201,a2.getBalance());



        for (Account a:transactionMap.keySet()) {
            System.out.println("-----------------------"+a.getAcId()+"-----------------------");
            transactionMap.get(a).forEach(System.out::println);
        }

    }
}
class AccountComparator implements Comparator<Account>{


    @Override
    public int compare(Account o1, Account o2) {
        return  o1.getAcId()-o2.getAcId();
    }
}