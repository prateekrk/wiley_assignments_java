package com.prateek.concurrentCollections.Threadss;

public class Practise {
    public static void main(String args[]){
        Numbers n=new Numbers();
        Thread t1=new Thread(n);
        Thread t2=new Thread(n);
        Thread t3=new Thread(n);
        Thread t4=new Thread(n);
        Thread t5=new Thread(n);
        Thread t6=new Thread(n);
        Thread t7=new Thread(n);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t1.getId();
    }
}
class Numbers implements Runnable {
    private int count;
     synchronized void increment() {
        try {
            Thread.sleep(10);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       count++;
    }
    @Override
    public void run() {

            this.increment();
            System.out.println(Thread.currentThread().getName()+":"+this.count);

    }
}
