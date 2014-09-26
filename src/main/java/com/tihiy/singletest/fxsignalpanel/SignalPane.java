package com.tihiy.singletest.fxsignalpanel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polyline;

public class SignalPane extends ScrollPane{
    private Polyline polyline;
    private ScrollBar bar;
    private int scrollValue;
    private int scale = 50;

    public SignalPane(double[] array) {
        super();
        setFitToHeight(true);
        setStyle("-fx-border-style: solid;"
                + "-fx-border-width: 1;"
                + "-fx-border-color: blue");
        setPrefHeight(Double.MAX_VALUE);
        VBox box = new VBox();
        box.getChildren().addAll(polyline = fillPoliline(array));
//        box.getChildren().addAll(initScrollBar());
        setContent(box);
    }

    private Polyline fillPoliline(double[] array){
        double[] polyArray = new double[array.length*2];
        for(int i = 0; i < array.length; i++){
            polyArray[i*2] = i*scale;
            polyArray[i*2 + 1] = array[i];
        }
        return new Polyline(polyArray);
    }
    private ScrollBar initScrollBar(){
        widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                bar.setPrefWidth(getWidth());
                System.out.println("Width of pane = "+ getWidth());
            }
        });
        bar = new ScrollBar();
        bar.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                polyline.relocate(bar.getValue(), 0);
            }
        });
        return bar;
    }
}
