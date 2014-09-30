package com.tihiy.fxtest;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ParamPanelControl implements Initializable{
    public VBox parampanel;
    private List<DoubleProperty> list;

    public TextField a;
    public TextField b;
    public TextField ro1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Init param control");
        DoubleProperty aDouble = new SimpleDoubleProperty();
        a.textProperty().bindBidirectional(aDouble, new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return String.valueOf(object.doubleValue());
            }
            @Override
            public Number fromString(String string) {
                return Double.valueOf(string);
            }
        });
        b.textProperty().bindBidirectional(aDouble, new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return String.valueOf(object.doubleValue());
            }

            @Override
            public Number fromString(String string) {
                aDouble.setValue(Double.valueOf(string));
                return Double.valueOf(string);
            }
        });
        aDouble.addListener((o,oldV,newV) -> System.out.println("New value"+newV.doubleValue()));
    }
}
