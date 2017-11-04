package com.tihiy.tabletest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableGetter {
    public List<List<String>> getTable(){
        List<List<String>> list = new ArrayList<>();
//                Arrays.asList(
//                Arrays.asList("1","Alex","Sony"),
//                Arrays.asList("2","John","Apple"),
//                Arrays.asList("3","Mike","Samsung")
//        );
        for (int i = 0; i <  300000; i++) {
            list.add(Arrays.asList("n "+i,"AlexAlex Alex Alex Alex Alex Alex Alex  " +i,"SonyAlex Alex Alex Alex Alex Alex Alex Alex "));
        }
        return list;
    }
    public ObservableList<TableSample.Person> getObservTable(){
        ObservableList<TableSample.Person> table = FXCollections.observableArrayList();
        getTable().forEach(x->{
            table.add(new TableSample.Person(x.get(0),x.get(1),x.get(2)));
        });
        return table;
    }
}
