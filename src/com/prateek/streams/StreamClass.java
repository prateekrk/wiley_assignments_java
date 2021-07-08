package com.prateek.streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamClass {
    public static void main(String args[]) throws FileNotFoundException {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> nums = new ArrayList<Integer>();
        List<Integer>x=new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            nums.add(a[i]);
        }
        nums
                .stream()
                .filter(n->n%2==0)
                .forEach(System.out::println);
        String names="";
        try {
            FileReader name = new FileReader("C:\\Users\\prate\\Desktop\\names.txt");
            while((int) name.read()!=-1){
                //
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
