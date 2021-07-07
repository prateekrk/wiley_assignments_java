package com.prateek.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamClass {
    public static void main(String args[]) {
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
    }
}
