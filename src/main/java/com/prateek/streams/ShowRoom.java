package com.prateek.streams;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShowRoom {
    public static void main(String args[]) {

        List<vehicle> vehicles= Arrays.asList(
                new vehicle("q7",2016,160),
                new vehicle("r8",2017,220),
                new vehicle("mustang gt",2013,190));

        List<Car> cars=new ArrayList<>();

        cars=vehicles.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        cars.forEach(e->System.out.println(e.toString()));

    }

}
