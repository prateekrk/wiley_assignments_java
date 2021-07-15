package com.prateek.concurrentCollections.Threadss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolClass {
    public static void main(String[] args) {

        // Thread Pool Executor

        // Types of Executor

        // SingleThreadPool Executor - performs sequential execution / allows only one thread
        // FixedThreadPool - we can specify a fixed set of threads
        // ScheduledThreadPool - tasks are executed in intervals
        // CachedThreadPool - keeps the data in an interim state & allows to processs from there


        // create the instance


        // create a thread
        // Thread t1 = new Thread(threadPool);

        // start the thread
        // t1.start();

        // use the executor service instead

        // use single thread
        //ExecutorService service = Executors.newSingleThreadExecutor();

        // executor service facilitates the worker threads


        // spawn the thread pool for the object

        //execute doesnt return us anything

//        service.execute(object1);

        // service.shutdown();
//
//        try{
//            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
//        }catch (InterruptedException ex){
//            ex.printStackTrace();
//        }

//        service.execute(object2);
//        service.execute(object1);
//

        // we can return


        List<Integer> a=new ArrayList<>();
        FibonacciPool object = new FibonacciPool(a,8);
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(object);
        // close of the thread pool
        // just a request to close of the link eventually

        FibonacciService fibService = new FibonacciService(a);

        Future<String> callFuture = service.submit(fibService); // task 1

        try{

            System.out.println("Sum Accumulation of fib series "+callFuture.get());

        }catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }
        //service.shutdown();

        Future<String>  callFuture1 = service.submit(fibService); // task 2
        // interrupt a running thread

        callFuture1.cancel(true);
        service.shutdown();
    }
}

class FibonacciPool implements Runnable{
    List<Integer> a=new ArrayList<>();
    int n;
    FibonacciPool(List<Integer> a,int n){
        this.a=a;
        this.n=n;
    }
    int findFib(int n) {

        if (n <=1) {
            return 1;
        }
        return findFib(n - 1) + findFib(n - 2);
    }
    void process(int n) throws InterruptedException{
        synchronized (a){
            a.add(findFib(n));
            System.out.println(n+"th Fib :" + findFib(n));
            a.notifyAll();
        }

    }

    @Override
    public void run() {
        for(int i=0;i<=n;i++){
            try{
                process(i);
            }
            catch  (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class FibonacciService implements Callable<String> {
    List<Integer> a=new ArrayList<>();
    int sum=0;
    FibonacciService(List<Integer> a){
        this.a=a;
    }
    int findFib(int n) {

        if (n <= 1) {
            return 1;
        }

        return findFib(n - 1) + findFib(n - 2);
    }
    @Override
    public String call() {
        StringBuilder response = new StringBuilder();
        for (int i = 0; i <=a.size(); i++) {
            try{
                Thread.sleep(10);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            response.append(sum+findFib(i));
            sum+=findFib(i);
            response.append(" ");
        }
        return response.toString();
    }
}