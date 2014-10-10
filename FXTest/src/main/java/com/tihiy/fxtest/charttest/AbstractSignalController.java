package com.tihiy.fxtest.charttest;

import javafx.beans.property.ListProperty;

public abstract class AbstractSignalController {
    SignalModelInterface model;

    void bindAll(){
        bindSignal();
        bindName();
        bindSampleFreq();
    }
    abstract void setModel(SignalModelInterface model);
    abstract void bindSignal();
    abstract void bindName();
    abstract void bindSampleFreq();
}
