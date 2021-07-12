package com.prateek.concurrentCollections.Threadss;

import com.prateek.Main;
import miniProject1.Address;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;


/**
 * ways to create threads
 *  1. Thread class
 *  2. Runnable Interface
 *  3. Callable Interface
 *  4. Executor Service / Framework
 *
 *  Types of Threads
 *  1. Priority Threads - they have high priority & can manipulate the JVM from processing
 *  2. Daemon Threads - they are low priority threads & cant prevent JVM from exiting , they always run in background
 *
 *
 *  Thread life cycle
 *  1. New thread
 *  2.Runnable
 *  3. Waiting/sleep
 *  4.blocked
 *  5.terminated
 * */




public class MainClass {
    static int n=100;

    public static void main(String args[]) throws InterruptedException {
        ThreadB t=new ThreadB();
        ThreadC t2=new ThreadC();
        ThreadA t1=new ThreadA();

        Thread tr=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<MainClass.n/3;i++){
                    if(i%2==0){
                        System.out.println("ThreadA Even -"+i);
                    }
                }
            }
        });
        Thread tr1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = MainClass.n/3; i<2*MainClass.n/3; i++){
                    if(i%2==0){
                        System.out.println("ThreadB Even -"+i);
                    }
                }
            }
        });
        Thread tr2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=2*MainClass.n/3;i<MainClass.n;i++){
                    if(i%2==0){
                        System.out.println("ThreadC Even -"+i);
                    }
                }
            }
        });


//        System.out.println("1"+Instant.now());
//        tr.start();
//        tr.join();
//        tr1.start();
//        tr1.join();
//        tr2.start();
//        tr2.setPriority(Thread.MAX_PRIORITY);
//


//        System.out.println("1"+Instant.now());

//        int x=0;
//        System.out.println("2"+Instant.now());
//        for(int i=0;i<n;i++){
//            if(i%2==0){
//                System.out.println("Even"+i);
//            }
//        }
//        System.out.println("2"+Instant.now());
//
//        System.out.println(tr.getId());
//        System.out.println(tr1.getId());
//        System.out.println(tr2.getId());
//        System.out.println(tr.toString());
//        System.out.println(tr.getContextClassLoader().toString());

//        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
//        threadSet.stream().forEach(e->System.out.println(e.getId()));

//        AddNum a=new AddNum();
//        Thread a1=new Thread(a,"a1");
//        Thread a2=new Thread(a,"a2");
//
//        a1.run();
//        a2.run();

        EmpService empService = new EmpService();

        Thread empThread1 = new Thread(empService);

        Thread empThread2 = new Thread(empService);

        // start the thread
        empThread1.start();
        empThread2.start();

        empService.getIntegers().forEach(in-> System.out.print(in+" "));
        System.out.println(empService.getIntegers().size());
    }
}
class ThreadA implements   Runnable{
    @Override
    public synchronized void run() {
        for(int i=0;i<MainClass.n/3;i++){
            if(i%2==0){
                System.out.println("ThreadA Even -"+i);
            }
        }
    }
}
class ThreadB implements Runnable{
    @Override
    public synchronized void run() {
        for(int i = MainClass.n/3; i<2*MainClass.n/3; i++){
            if(i%2==0){
                System.out.println("ThreadB Even -"+i);
            }
        }
    }
}
class ThreadC implements   Runnable{
    @Override
    public synchronized void run() {
        for(int i=2*MainClass.n/3;i<MainClass.n;i++){
            if(i%2==0){
                System.out.println("ThreadC Even -"+i);
            }
        }
    }

}
class AddNum implements  Runnable{
    List<Integer> x;
    @Override
    public void run() {
        x=new ArrayList<>();
        for(int i=0;i<100;i++){
            x.add(i);
            System.out.println(Thread.currentThread().getName()+"------"+i);
        }
    }
}
class EmpService implements Runnable{

    private List<Integer> integers = new ArrayList<>();

    @Override
    public void run() {


        for (int i = 100; i > 0 ; i--) {
            if (!integers.contains(i)) {
                integers.add(i);
//              System.out.println(Thread.currentThread().getName() + " ---- " + i);
            }
        }
    }

    public List<Integer> getIntegers() {
        return integers;
    }
}