package banking;

public class Transactions {
    private String type;
    private double amnt;
    private int acId;
    public Transactions(int acId,String type,double amnt){
        this.type=type;
        this.amnt=amnt;
        this.acId=acId;
    }

    int getAcId(){
        return acId;
    }

    public String toString(){
        return "Account : "+acId+" Type :"+type+" Amount : "+amnt;
    }

}
