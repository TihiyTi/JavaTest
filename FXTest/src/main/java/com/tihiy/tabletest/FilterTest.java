package com.tihiy.tabletest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));
        List<Integer> sublist = list.subList(2,4);
        System.out.println(list);
        System.out.println(sublist);
        sublist.addAll(sublist);
        System.out.println(sublist);
        System.out.println(list);
    }
}
