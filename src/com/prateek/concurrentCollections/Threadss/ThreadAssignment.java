package com.prateek.concurrentCollections.Threadss;

import javax.security.sasl.SaslServer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadAssignment {
   int[] a;
    void fib(int n){
        a=new int[n+1];
        int n1=0,n2=1,n3,i;
        a[0]=0;
        a[1]=1;
        for(i=2;i<=n;++i)//loop starts from 2 because 0 and 1 are already printed
        {
            n3=n1+n2;
            a[i]=n3;
            n1=n2;
            n2=n3;
        }
    }
    public static void main(String args[]){
        ThreadAssignment t=new ThreadAssignment();
        int n=7;

        //fibonacci series till nth term
        t.fib(n);

        //accumulate sum
        final int[] sum = {0};

        //array list of sum
        ArrObj[] arr=new ArrObj[n+1];


//        Thread 1 from sum of total nums in series

        Thread tr=new Thread(new Runnable() {
            @Override
            public void run() {
               for(int i=1;i<t.a.length;i++){
                   sum[0]+=t.a[i];
               }
                System.out.println("Accumlate sum of fib series="+ sum[0]);
            }
        });

        //Thread 2 for accumulation array

        Thread tr2=new Thread(new Runnable() {
            int sum=0;
            @Override
            public void run() {
                System.out.println("Contents of accumulated array:");
                for (int i=1;i<t.a.length;i++){
                    arr[i]=(new ArrObj(sum,t.a[i]));
                    sum+=t.a[i];
                    System.out.println(arr[i].toString());

                }
            }
        });
        tr.start();
        tr2.start();
    }
}
class ArrObj{
    private int a,b,sum;

    public ArrObj(int a,int b){
        this.b=b;
        this.a=a;

    }

    int calSum(int a,int b){
        return a+b;
    }

    public int getB() {
        return b;
    }

    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return a+"+"+b+"="+calSum(a,b);
    }
}

