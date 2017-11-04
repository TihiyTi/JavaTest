package com.nedlermead;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        Map<String,List<Double>> map =  new HashMap<>();
        List<Double> list = Arrays.asList(1., 2., 3., 4., 5., 6.);
        List<Double> list2 = Arrays.asList(7., 8., 9., 10., 11., 12.);
        map.put("one",list);
        map.put("two",list2);


        map.keySet().stream().map(map::get).flatMap(Collection::stream).collect(Collectors.toList()).forEach(System.out::println);
//        double value = list.stream().mapToDouble(StreamTest::doSomethings).sum();
//        System.out.println(""+value);
    }

    public static double doSomethings(double d){
        return d*d;
    }
}
