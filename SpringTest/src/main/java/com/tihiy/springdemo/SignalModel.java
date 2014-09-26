package com.tihiy.springdemo;

import com.tihiy.springdemo.abs.AbstractModel;

import java.util.ArrayList;
import java.util.List;

public class SignalModel extends AbstractModel {
    private List<Double> list = getTestList();
    private String signalName;

    public SignalModel(String signalName) {
        this.signalName = signalName;
    }

    public void setList(List<Double> list) {
        firePropertyChange(signalName, this.list, list);
        this.list = list;
    }

    public List<Double> getList() {
        return list;
    }

    private List<Double> getTestList(){
        List<Double> value = new ArrayList<>();
        for(int i = 0; i < 300; i++ ){
            value.add(Math.random() * 100);
        }
        return value;
    }
}
