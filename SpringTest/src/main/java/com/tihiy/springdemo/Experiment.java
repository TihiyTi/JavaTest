package com.tihiy.springdemo;

import com.tihiy.springdemo.abs.AbstractMotherModel;

import java.util.ArrayList;
import java.util.List;

public class Experiment extends AbstractMotherModel implements ExperimentInterface {
    private String expName;
    private List<List<Double>> listOfPulse = new ArrayList<>();
    private List<List<Double>> listOfBase = new ArrayList<>();
    private List<Double> firstPulse;
    private List<Double> firstBase;
//    private

    public Experiment(String expName) {
        this.expName = expName;
        System.out.println(this.expName);
    }


    public void setPulseChannel(String...list){
        for (String s : list) {
            addModel(s, new SignalModel(s));
            listOfPulse.add(new ArrayList<>());
        }
    }
    public void setBaseChannel(String...list){
        for (String s : list) {
            addModel(s, new SignalModel(s));
            listOfBase.add(new ArrayList<>());
        }
    }
    public void setFirst(String...first){
        firstPulse = new ArrayList<>();
        firstBase = new ArrayList<>();
        addModel(first[0], new SignalModel(first[0]));
        addModel(first[1], new SignalModel(first[1]));
    }

    @Override
    public List<List<Double>> getListOfPulse() {
        return listOfPulse;
    }

    @Override
    public List<List<Double>> getListOfBase() {
        return listOfBase;
    }

    @Override
    public List<Double> getFirstPulse() {
        return firstPulse;
    }

    @Override
    public List<Double> getFirstBase() {
        return firstBase;
    }
}
