package com.tihiy.fxtest.charttest;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class LineChartController extends AbstractSignalController implements Initializable{
    public LineChart<Number,Number> chart;
    public NumberAxis xAxis;
    public NumberAxis yAxis;
    public String id;
    ListProperty<Double> listXProperty = new SimpleListProperty<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(model==null){
            chart.setTitle("CHARRT");
            xAxis.setLabel("X Axis");
            yAxis.setLabel("Y Axis");

            listXProperty.addListener((observable, oldValue, newValue) -> {
                XYChart.Series<Number,Number> series = new XYChart.Series<>();
                series.setName("Data Series 1");
                for (int i = 0; i < newValue.size(); i++) {
                    series.getData().add(new XYChart.Data<>(i, newValue.get(i)));
                }
                chart.getData().add(series);
            });
        }else {
            bindAll();
        }
    }

    public void bindList(ListProperty<Double> list){
        listXProperty.bindBidirectional(list);
    }

    @Override
    public void setModel(SignalModelInterface model) {
        this.model = model;

    }

    @Override
    void bindSignal() {
        model.getSignal().addListener((observable, oldValue, newValue) -> {
            XYChart.Series<Number,Number> series = new XYChart.Series<>();
            series.setName("Data Series 1");
            for (int i = 0; i < newValue.size(); i++) {
                series.getData().add(new XYChart.Data<>(i/model.getSampleFreq()., newValue.get(i)));
            }
            chart.getData().add(series);
        });
    }

    @Override
    void bindName() {
        chart.setTitle(model.getName().getValue());
    }

    @Override
    void bindSampleFreq() {
    }
}
