package banking;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    int custId;
    List<Account> accounts=new ArrayList<>();


    public Customer(int custId){
        this.custId=custId;
    }

    public int getCustId() {
        return custId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return String.valueOf(custId);
    }
}
