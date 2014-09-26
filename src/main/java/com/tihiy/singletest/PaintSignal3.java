package com.tihiy.singletest;

import com.tihiy.singletest.fxsignalpanel.SignalPanel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaintSignal3 extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
    }

    private void init(Stage primaryStage) {

        primaryStage.setScene(new Scene(new SignalPanel(3,true), 600, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
