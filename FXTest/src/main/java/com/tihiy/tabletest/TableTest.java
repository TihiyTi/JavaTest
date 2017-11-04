package com.tihiy.tabletest;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TableTest extends Application {


    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }
    @Override
    public void stop() throws Exception{
        super.stop();
        System.exit(0);
    }

}
