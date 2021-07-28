package com.prateek.collections.map;

import java.util.HashMap;
import java.util.Hashtable;

public class MainClass {
    public static void main(String args[]){
        Hashtable<java.io.Serializable, java.io.Serializable> m=new Hashtable<>();
        m.put(1,"1");
        m.put(1,2);
        System.out.println(m.get(1));
          }
}
