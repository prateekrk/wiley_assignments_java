package eegs;

public class EggsCalculationClass {
    int num;
    EggsCalculationClass(int num){
        this.num=num;
    }

    public int getGross() {
        int x=num/144;
        num=num%144;
        return x;
    }

    public int getDozen() {
        int x=num/12;
        num=num%12;
        return x;
    }


    public int getRem() {
        return num;
    }
}
