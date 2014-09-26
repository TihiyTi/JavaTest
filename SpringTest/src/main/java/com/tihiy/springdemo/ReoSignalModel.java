package com.tihiy.springdemo;

import com.tihiy.springdemo.abs.AbstractModel;

import java.util.List;

public class ReoSignalModel extends AbstractModel implements SignalInterface,BaseSignalInterface{
    private List<Double> signal;
    private List<Double> baseSignal;
    private String signalName;

    public void setSignalName(String signalName) {
        this.signalName = signalName;
    }

    @Override
    public void setBaseList(List<Double> list) {
        baseSignal = list;
    }

    @Override
    public void setList(List<Double> list) {
        signal = list;
    }
}
