package com.tihiy.fxtest.charttest;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.StringProperty;

public interface SignalModelInterface {
    public ListProperty<Double> getSignal();
    public StringProperty getName();
    public IntegerProperty getSampleFreq();
}
