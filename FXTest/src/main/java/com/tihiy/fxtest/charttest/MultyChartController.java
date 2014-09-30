package com.tihiy.fxtest.charttest;

import javafx.beans.property.ListProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class MultyChartController {

    public VBox vbox;

    public void setSignals(List<ListProperty<Double>> listOfLists) throws IOException {
        int numOfSignals = listOfLists.size();
        for (ListProperty<Double> list : listOfLists) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chart.fxml"));
            vbox.getChildren().add(loader.load());
            ((LineChartController)loader.getController()).bindList(list);
        }
    }
}
