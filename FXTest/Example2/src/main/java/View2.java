import javafx.beans.NamedArg;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class View2 extends LineChart {

    ListProperty<Double> list = new SimpleListProperty<>();
    Task<Date> task;
    Series<Double, Double> series = new Series<>();
    ObservableList<Data<Double,Double>> observableList = FXCollections.observableList(new ArrayList<>());
    static int size=0;

    public View2(@NamedArg("xAxis") NumberAxis axis, @NamedArg("yAxis") NumberAxis axis2) {
        super(axis, axis2);
        series.setData(observableList);
        series.setName("Data Series 1");

        getData().add(series);

        task =new Task<Date>() {
            @Override
            protected Date call() throws Exception {
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException iex) {
                        Thread.currentThread().interrupt();
                    }

                    if (isCancelled()) {
                        break;
                    }

                    updateValue(new Date());
                }
                return new Date();
            }
        };

        task.valueProperty().addListener(new ChangeListener<Date>() {
            @Override
            public void changed(ObservableValue<? extends Date> observable, Date oldValue, Date newValue) {

                change2();
            }
        });

        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(task,5L,5L,TimeUnit.SECONDS);
    }

    public void change(){
        observableList.addAll(new XYChart.Data<>((double) size, (double)size++));
    }
    public void change2() {
        List l = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            l.add(new XYChart.Data<>((double) i, (double)list.get(i)));
        }
        series.setData(FXCollections.observableList(l));
    }


}
