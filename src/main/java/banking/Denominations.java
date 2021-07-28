package banking;

public class Denominations {
    private int deno50,deno10;

    Denominations(int d50,int d10){
        this.deno10=d10;
        this.deno50=d50;
    }

    public int getDeno10() {
        return deno10;
    }

    public int getDeno50() {
        return deno50;
    }

    @Override
    public String toString() {
        return "50's :"+deno50+" 10's"+deno10;
    }
}
