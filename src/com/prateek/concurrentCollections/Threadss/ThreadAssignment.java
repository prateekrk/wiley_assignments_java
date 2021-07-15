package com.prateek.concurrentCollections.Threadss;

import javax.security.sasl.SaslServer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class ThreadAssignment {
//   int[] a;
//    void fib(int n){
//        a=new int[n+1];
//        int n1=0,n2=1,n3,i;
//        a[0]=0;
//        a[1]=1;
//        for(i=2;i<=n;++i)//loop starts from 2 because 0 and 1 are already printed
//        {
//            n3=n1+n2;
//            a[i]=n3;
//            n1=n2;
//            n2=n3;
//        }
//    }
    public static void main(String args[]){
//        ThreadAssignment t=new ThreadAssignment();
//        int n=7;
//
//        //fibonacci series till nth term
//        t.fib(n);
//
//        //accumulate sum
//        final int[] sum = {0};
//
//        //array list of sum
//        ArrObj[] arr=new ArrObj[n+1];
//
//
////        Thread 1 from sum of total nums in series
//
//        Thread tr=new Thread(new Runnable() {
//            @Override
//            public void run() {
//               for(int i=1;i<t.a.length;i++){
//                   sum[0]+=t.a[i];
//               }
//                System.out.println("Accumlate sum of fib series="+ sum[0]);
//            }
//        });
//
//        //Thread 2 for accumulation array
//
//        Thread tr2=new Thread(new Runnable() {
//            int sum=0;
//            @Override
//            public void run() {
//                System.out.println("Contents of accumulated array:");
//                for (int i=1;i<t.a.length;i++){
//                    arr[i]=(new ArrObj(sum,t.a[i]));
//                    sum+=t.a[i];
//                    System.out.println(arr[i].toString());
//
//                }
//            }
//        });
//        tr.start();
//        tr2.start();
        List<Integer> a=new ArrayList<>();

        Fibonacci f=new Fibonacci(a,7);
        sum s=new sum(a,7);

        Thread t1=new Thread(f);
        Thread t2=new Thread(s);
        t1.start();
        t2.start();


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
class Fibonacci implements Runnable {
    List<Integer> a = new ArrayList<>();
    int n;

    Fibonacci(List<Integer> a, int n) {
        this.a = a;
        this.n = n;
    }

    int findFib(int n) {

        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return findFib(n - 1) + findFib(n - 2);
    }

    void add(int n) throws InterruptedException {
        synchronized (a) {
            Thread.sleep(1000);
            a.add(findFib(n));
            System.out.println("produce " + findFib(n));
            a.notifyAll();
        }
    }
    @Override
    public void run() {
        int i=0;
        while(i<=n){
            try{
                add(i++);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

class sum implements Runnable{
    private List<ArrObj> arr=new ArrayList<>();
    private int n;
    private List<Integer> a=new ArrayList<>();
    private int s=0;
    sum(List<Integer> a,int n){
        this.n=n;
        this.a=a;
    }
    int sum(int a,int b){
        return a+b;
    }

    void consume() throws  InterruptedException{
        synchronized (a){
            while(a.isEmpty()){
                System.out.println("List is empty");
                a.wait();
            }
            Thread.sleep(500);
            int num=a.remove(0);
            arr.add(new ArrObj(s,num));
            System.out.println(num+" + "+s+" = "+(num+s));
            s+=num;
            a.notifyAll();
        }
    }

    @Override
    public void run() {

        int i=0;
        while (i <= n) {
            try {
                consume();
                i++;
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

