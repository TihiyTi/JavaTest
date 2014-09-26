package com.tihiy.springdemo;

import java.util.List;

public interface ExperimentInterface {
    public List<List<Double>> getListOfPulse();
    public List<List<Double>> getListOfBase();
    public List<Double> getFirstPulse();
    public List<Double> getFirstBase();
}
