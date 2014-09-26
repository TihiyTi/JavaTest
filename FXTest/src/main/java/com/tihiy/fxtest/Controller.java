package com.tihiy.fxtest;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    StringProperty bufProp1 = new SimpleStringProperty();
//    StringProperty bufProp2 = new SimpleStringProperty();

    public Label label;
    public Label label2;
    public TextField textField;
    public FlowPane pane;
    public Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initialize label "+ label.toString());
        Bindings.bindBidirectional(label.textProperty(), bufProp1);
        Bindings.bindBidirectional(label2.textProperty(), bufProp1);
        Bindings.bindBidirectional(textField.textProperty(), bufProp1);
    }

    public void setBindProperty(StringProperty property){
        Bindings.bindBidirectional(bufProp1, property);
//        Bindings.bindBidirectional(bufProp2, property);
    }

}
