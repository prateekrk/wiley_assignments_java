package eegs;

import java.util.Scanner;

public class MainClass {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        EggClass egg=new EggClass();
        while(true){
            System.out.println("1.Enter number of eggs\n2. Cal quantity ");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    int n=sc.nextInt();
                    egg.setNum(n);
                    break;
                case 2:
                    EggsCalculationClass eCal=new EggsCalculationClass(egg.getNum());
                    System.out.println("Gross : "+eCal.getGross());
                    System.out.println("Dozen : "+eCal.getDozen());
                    System.out.println("Remaining : "+eCal.getRem());
                default: System.exit(0);
            }
        }
    }
}
