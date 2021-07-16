package com.prateek.concurrentCollections.collections;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapClass {

   static String name[];
    static {
        String data="";
        String[] array=new String[71];
        try{
            int i=0;
            File f=new File("C:\\Users\\prate\\wiley_assignments\\src\\com\\prateek\\concurrentCollections\\collections\\names.txt");
            Scanner myReader = new Scanner(f);
            while (myReader.hasNextLine()) {
                String d = myReader.nextLine();
                array[i]=d;
                i++;
            }
            System.out.println(data);
            name=array;
            myReader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<Integer, String>(10,0.75f,2);

    public static void main(String args[]){
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        ConcurrentHashMapClass c=new ConcurrentHashMapClass();

        Collections.synchronizedMap(c.concurrentHashMap);


        executorService.execute(c.new AddElements1());

        executorService.execute(c.new read());

        executorService.execute(c.new StoreFile());

//        System.out.println(c.concurrentHashMap);
        executorService.shutdown();


    }
    class read implements  Runnable{
        @Override
        public void run() {
            for(Integer i:concurrentHashMap.keySet()){
                System.out.println("year "+i+" ----->"+concurrentHashMap.get(i));
            }
        }
    }

    class AddElements1 implements Runnable{
        @Override
        public void run(){
           for(int i=0;i<name.length;i++){
//               System.out.println(i+1+"----->"+name[i]);
               concurrentHashMap.put(i+1950,name[i]);
           }
        }
    }
    class AddElements2 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<name.length;i++){
//                System.out.println(i+1+"----->"+name[i]);
                concurrentHashMap.put(i+1950,name[i]);


            }
        }
    }
    class AddElements3 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<name.length;i++){
//                System.out.println(i+1+"----->"+name[i]);
                concurrentHashMap.put(i+1950,name[i]);

            }
        }
    }
    class AddElements4 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<name.length;i++){
//                System.out.println(i+1+"----->"+name[i]);
                concurrentHashMap.put(i+1950,name[i]);

            }
        }
    }
    class AddElements5 implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<name.length;i++){
//                System.out.println(i+1+"----->"+name[i]);
                concurrentHashMap.put(i+1950,name[i]);

            }
        }
    }
    class StoreFile implements  Runnable{
        Properties properties = new Properties();

        void Store(ConcurrentHashMap<Integer,String> c){
            try {
                File f1 = new File("champions.txt");
                f1.createNewFile();
                Properties properties = new Properties();

                for (Map.Entry<Integer, String> m : c.entrySet()){
                    properties.put(String.valueOf(m.getKey()),c.get(m.getKey()));
            }

                properties.store(new FileOutputStream("C:/Users/prate/wiley_assignments/src/com/prateek/concurrentCollections/collections/champions.properties"), "Winner of the driver championships with year");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            Store(concurrentHashMap);
        }
    }
}
