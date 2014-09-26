package com.tihiy.singletest;

import com.tihiy.singletest.fxsignalpanel.SignalBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaintSignal2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
    }

    private void init(Stage primaryStage) {
        SignalBox signalBox = new SignalBox(new double[]{1,100,20,40, 100, 10,100,50,100,1,20,40});
        primaryStage.setScene(new Scene(signalBox));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
