package banking;

class Card {
    private long  cardNum;
    private int pin;
    private Account ac;

    Card(long cardNum,int pin,Account ac){
        this.ac=ac;
        this.cardNum=cardNum;
        this.pin=pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public long getCardNum() {
        return cardNum;
    }

    public void setCardNum(long cardNum) {
        this.cardNum = cardNum;
    }

    public Account getAc() {
        return ac;
    }
}
