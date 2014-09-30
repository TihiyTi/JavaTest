package com.tihiy.fxtest;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class TabParamController implements Initializable {
    public VBox param2;
    public VBox param3;
    public VBox param4;
    public VBox param5;
    public VBox param;
    public ParamPanelControl paramController;
    public ParamPanelControl param2Controller;
    public ParamPanelControl param3Controller;
    public ParamPanelControl param4Controller;
    public ParamPanelControl param5Controller;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paramController.a.textProperty().addListener((observable, oldValue, newValue) -> System.out.println(" a = " + newValue));
        param2Controller.a.textProperty().addListener((observable, oldValue, newValue) -> System.out.println(" a = " + newValue));
        param3Controller.a.textProperty().addListener((observable, oldValue, newValue) -> System.out.println(" a = " + newValue));
        param4Controller.a.textProperty().addListener((observable, oldValue, newValue) -> System.out.println(" a = " + newValue));
        param5Controller.a.textProperty().addListener((observable, oldValue, newValue) -> System.out.println(" a = " + newValue));
//        paramController.initialize(location, resources);
    }
}
