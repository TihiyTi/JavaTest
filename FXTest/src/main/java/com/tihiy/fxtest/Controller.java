package com.tihiy.fxtest;

import javafx.beans.binding.Bindings;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    public Label label;
    public TextField textField;
    public FlowPane pane;
    public Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Bindings.bindBidirectional(label.textProperty(), textField.textProperty());
    }


}
