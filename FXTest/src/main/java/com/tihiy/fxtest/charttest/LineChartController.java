package com.tihiy.fxtest.charttest;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class LineChartController implements Initializable{
    public LineChart<Number,Number> chart;
    public NumberAxis xAxis;
    public NumberAxis yAxis;

    ListProperty<Double> listXProperty = new SimpleListProperty<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chart.setTitle("CHARRT");
        xAxis.setLabel("X Axis");
        yAxis.setLabel("Y Axis");

        listXProperty.addListener((observable, oldValue, newValue) -> {
            XYChart.Series<Number,Number> series = new XYChart.Series<>();
            series.setName("Data Series 1");
            newValue.forEach(e -> {
                series.getData().add(new XYChart.Data<>(newValue.indexOf(e), e));
            });
            chart.getData().add(series);
        });
    }

    public void bindList(ListProperty<Double> list){
        listXProperty.bindBidirectional(list);
    }
}
