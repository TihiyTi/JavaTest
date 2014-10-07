package com.tihiy.fxtest;

import com.sun.javafx.css.CssError;
import com.tihiy.fxtest.charttest.Chart1Controller;
import com.tihiy.fxtest.charttest.GetID;
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
import javafx.util.Callback;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            fxmlLoader.setControllerFactory(e -> {
                String[] st = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(context, e);
                for (String s : st) {
                    System.out.print(s + "  ");
                    System.out.println();
                }
                return BeanFactoryUtils.beanOfType(context, e);
            });
//            fxmlLoader.setControllerFactory(new Callback<Class<?>, Object>() {
//                Map<String, Integer> map = new HashMap<String, Integer>();
//                @Override
//                public Object call(Class<?> param) {
//                    String[] st = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(context, param);
//                    if(st.length > 1){
//                        if(!map.containsKey(param.getName())){
//                            map.put(param.getName(), 0);
//                        }
//                        LineChartController mc = ((LineChartController)param.cast(new LineChartController()));
//                        System.out.println(mc.id);
//                    }
//                    if(param.getName().contains("LineChartController")){
//                        Map map = BeanFactoryUtils.beansOfTypeIncludingAncestors(context, param);
//                        return null;
//                    }
////                    Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Using provided controller");
//                    return BeanFactoryUtils.beanOfType(context, param);
//                }
//            });
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

//            mc.setBindGraph(Arrays.asList(listProperty, listProperty2));
//            chartController2.bindList(listProperty);
//            mc.setBindProperty(prop);
            prop.addListener((observable, oldValue, newValue) -> System.out.println("TEST COMPLETE!!"));

//            MultyChartController mult = (MultyChartController)context.getBean("mult");
//            mult.setSignals(Arrays.asList(listProperty, listProperty2));
            Map map = context.getBeansOfType(LineChartController.class);
            LineChartController mc3 = getBeanForID(LineChartController.class, "chartmc1", context);
            LineChartController mc1 = (LineChartController)context.getBean("chart11");
            LineChartController mc2 = (LineChartController)context.getBean("chart22");
            List<Double> list3 = Arrays.asList(1d, 1d, 1d, 1d, 1d, 1d);
            List<Double> list4 = Arrays.asList(4d, 4d, 4d, 4d, 4d, 4d);
            ObservableList<Double> observableList3 = FXCollections.observableList(list3);
            ObservableList<Double> observableList4 = FXCollections.observableList(list4);
            ListProperty<Double> listProperty3 = new SimpleListProperty<>(observableList3);
            ListProperty<Double> listProperty4 = new SimpleListProperty<>(observableList4);
            mc1.bindList(listProperty3);
            mc2.bindList(listProperty4);

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

    public <T> T getBeanForID(Class<T> clazz, String ID, ListableBeanFactory con){
        Map<String, T> map = con.getBeansOfType(clazz);
        String[] st = con.getBeanNamesForType(clazz);
        LineChartController t = (LineChartController) con.getBean(st[0]);
        T value = null;
        for (String s : map.keySet()) {
            if(((GetID)map.get(s)).getID().equals(ID)) {
                value = map.get(s);
            }
        }
        return value;
    }
}
