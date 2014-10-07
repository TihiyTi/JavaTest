package com.tihiy.fxtest;

import com.tihiy.fxtest.charttest.LineChartController;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    StringProperty bufProp1 = new SimpleStringProperty();
//    StringProperty bufProp2 = new SimpleStringProperty();

    public Label label;
    public Label label2;
    public TextField textField;
    public FlowPane pane;
    public LineChart chartmc1;
    public LineChart chartmc2;
    public LineChartController chartmc1Controller;
    public LineChartController chartmc2Controller;
    public Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Controller FX "+ this.toString());
//        Bindings.bindBidirectional(label.textProperty(), bufProp1);
//        Bindings.bindBidirectional(label2.textProperty(), bufProp1);
//        Bindings.bindBidirectional(textField.textProperty(), bufProp1);
    }

    public void setBindProperty(StringProperty property){
        Bindings.bindBidirectional(bufProp1, property);
    }
    public void setBindGraph(List<ListProperty<Double>> listOfListProperty){
        chartmc1Controller.bindList(listOfListProperty.get(0));
        chartmc2Controller.bindList(listOfListProperty.get(1));
    }
}
