import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Model2 {


    ListProperty<Double> list = new SimpleListProperty<>();
    StringProperty stringProperty = new SimpleStringProperty();

    public Model2() {
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(() -> {
            List<Double> tempList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                tempList.add(Math.random());
            }
            System.out.println("New list");
            list.setValue(FXCollections.observableList(tempList));
        }, 5L, 5L, TimeUnit.SECONDS);

    }

    public void setList(List<Double> list) {
        ObservableList<Double> observableList = FXCollections.observableList(list);
        this.list.setValue(observableList);
    }


}
