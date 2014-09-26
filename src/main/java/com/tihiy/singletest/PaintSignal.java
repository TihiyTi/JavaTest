package com.tihiy.singletest;

import com.tihiy.singletest.fxsignalpanel.SignalBox;
import com.tihiy.singletest.fxsignalpanel.SignalPane;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created with IntelliJ IDEA.
 * User: Alex
 * Date: 04.08.14
 * Time: 19:42
 */
public class PaintSignal extends Application {
    int mouseX = 0;
    Text text;
    private void init(Stage stage){

//        Group root = new Group();
//        root.setStyle("-fx-border-style: solid;"
//                + "-fx-border-width: 1;"
//                + "-fx-border-color: green");

        SignalPane signalPane = new SignalPane(new double[]{1,100,20,40, 100, 10,100,50,100,1,20,40});
        SignalBox signalBox = new SignalBox(new double[]{1,100,20,40, 100, 10,100,50,100,1,20,40});
//        SignalPane signalPane2 = new SignalPane(new double[]{1,100,20,40, 100, 10,100,50,100,1,20,40});
//        Pane pane = new Pane();
//        pane.setPrefSize(500, 250);
//        pane.setOnMouseMoved(paneOnMouseEventHandler);
//        pane.setOnMouseMoved(paneOnMouseMovedEventHandler);
//        text = new Text(0,0, "MouseX = " + mouseX);
//        text.setStyle("-fx-font-size: 22;");
//        text.setTextOrigin(VPos.TOP);
//        text.setTextAlignment(TextAlignment.CENTER);
//        Polyline polyline1 = new Polyline(5, 500,10, 100, 15, 200, 20, 50);
//        pane.getChildren().addAll(polyline1, text);
//        pane.setTranslateX(200);
//
        VBox box = new VBox();
        box.getChildren().addAll(signalPane, signalBox);
//        box.setAlignment(Pos.BASELINE_CENTER);
        box.setStyle("-fx-border-style: solid;"
                + "-fx-border-width: 1;"
                + "-fx-border-color: red");
        box.setFillWidth(true);
        stage.setScene(new Scene(box, 500, 250));
    }


    @Override
    public void start(Stage stage) throws Exception {
        init(stage);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    EventHandler<MouseEvent> paneOnMouseEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {

              text.setText("MouseX = " + mouseEvent.getX());
        }
    };

}
