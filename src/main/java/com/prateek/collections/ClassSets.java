package com.prateek.collections;

import java.time.Instant;
import java.util.*;

public class ClassSets {

    void main() {
        System.out.println("\n--------------Hash Set------------------\n");

        Set<Integer> s = new HashSet();
        for (int i = 0; i < 200; i++) {
            s.add(i);
        }


        /*
        * allows only one null
        * retains insertion order
        * */
        //stream on set
        System.out.println(Instant.now());
        s.stream().filter(n->n%2==0).
                forEach(System.out::println);
        System.out.println(Instant.now());

        //parallel stream set ##multi threaded
        System.out.println("-------parallel stream--------");
        System.out.println(Instant.now());
        s.parallelStream()
                .filter(n->n%2==0)
                .forEach(System.out::println);
        System.out.println(Instant.now());

        //null values in hashset
        //takes only one values
        Set s1=new HashSet();
        s1.add(null);
        s1.add(null);
        s1.add(1);
        s1.parallelStream().forEach(System.out::println);


        /*
        * Tree set
        * Uses tree map to store values
        *doesn't allow null values
        *
        *
        * */

        System.out.println("\n--------------Tree Set------------------\n");
        Set<MyObject>treeSet= new TreeSet();

        treeSet.add(new MyObject(1));
        treeSet.add(new MyObject("hey1"));
        treeSet.add(new MyObject(2));
        treeSet.add(new MyObject("0"));
        treeSet.add(new MyObject("a"));
        treeSet.add(new MyObject("hey0"));
        treeSet.add(new MyObject(null));

        treeSet.forEach(e->System.out.println(e.toString()));



//        Set t=new TreeSet();
//        for(int i=0;i<=1000;i++){
//            t.add(i);
//        }
//        t.add(-1);


    }
}

class MyObject implements Comparable {
    private Object o;
    MyObject(Object o){
        this.o=o;
    }

    @Override
    public int compareTo(Object object) {
        MyObject m=(MyObject) object;
        return String.valueOf(this.o).compareTo(String.valueOf(object));
    }

    @Override
    public String toString() {
        return String.valueOf(this.o);
    }
   public int hashCode(){
        return  o.hashCode();
   }

    }

class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String s=(String) o1;
        String s1=(String) o2;
        return (s).compareTo(s1);
    }
}

//2021-07-08T04:18:43.975Z
//2021-07-08T04:18:44.372Z
//2021-07-08T04:24:42.134Z
//2021-07-08T04:24:42.237Z