package banking;

public class Transactions {
    private String type;
    private double amnt;
    private Account ac;
    private double balance;
    private  Denominations denominations;
    public Transactions(Account a,String type,int amount,Denominations d ){
        this.type=type;
        this.amnt=amount;
        this.ac=a;
        this.denominations = d;
    }

    int getAcId(){
        return ac.getAcId();
    }

    public String toString(){
        return "Account : "+ ac.toString()+" Type :"+type+" Amount : "+amnt+ " Denominations : "+denominations;
    }

}
