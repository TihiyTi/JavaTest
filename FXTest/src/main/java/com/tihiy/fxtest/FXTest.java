package com.tihiy.fxtest;

import com.sun.javafx.css.CssError;
import com.tihiy.fxtest.charttest.LineChartController;
import com.tihiy.fxtest.charttest.MultyChartController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class FXTest extends Application {
    private static final String SCENE_XML = "scene.fxml";
    private static final String KEYS_PROPS = "keys";
    private static final String FX_CONTEXT_XML = "context.xml";


    private final ListableBeanFactory context = new ClassPathXmlApplicationContext(
            getClass().getPackage().getName().replaceAll("\\.", "/") + "/" + FX_CONTEXT_XML
    );

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        try{
            Class clazz = FXTest.class;
            URL location1 = clazz.getResource(SCENE_XML);
            FXMLLoader fxmlLoader = new FXMLLoader(location1);
            fxmlLoader.setControllerFactory(e -> BeanFactoryUtils.beanOfType(context, e));
            Pane root = fxmlLoader.load();

            stage.setScene(new Scene(root));
            stage.show();

            Controller mc = (Controller) context.getBean("mc");
            StringProperty prop = new SimpleStringProperty();
            List<Double> list = Arrays.asList(1d,34d,53d,23d,23d,43d);
            List<Double> list2 = Arrays.asList(21d,4d,3d,45d,23d,54d);
            ObservableList<Double> observableList = FXCollections.observableList(list);
            ObservableList<Double> observableList2 = FXCollections.observableList(list2);
            ListProperty<Double> listProperty = new SimpleListProperty<>(observableList);
            ListProperty<Double> listProperty2 = new SimpleListProperty<>(observableList2);

            mc.setBindGraph(Arrays.asList(listProperty, listProperty2));
//            chartController2.bindList(listProperty);
            mc.setBindProperty(prop);
            prop.addListener((observable, oldValue, newValue) -> System.out.println("TEST COMPLETE!!"));

            MultyChartController mult = (MultyChartController)context.getBean("mult");
            mult.setSignals(Arrays.asList(listProperty, listProperty2));

        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
    @Override
    public void stop() throws Exception{
        super.stop();
        System.exit(0);
    }
}
