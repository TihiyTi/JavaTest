package com.tihiy.fxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class FXTest extends Application {
    private static final String SCENE_XML = "scene.fxml";
    private static final String KEYS_PROPS = "keys";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        try{

            Class clazz = FXTest.class;
            URL location1 = clazz.getResource(SCENE_XML);
            FXMLLoader fxmlLoader = new FXMLLoader(location1);
            Pane root = fxmlLoader.load();

            stage.setScene(new Scene(root));
            stage.show();
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
