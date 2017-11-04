import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Example2 extends Application {

    Model2 model = new Model2();
    View2 chart = new View2(new NumberAxis(),new NumberAxis());
    TextField textField = new TextField();
    Label label =new Label();

    Button button = new Button();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));

        label.setLayoutX(100);
        label.setLayoutY(100);
        textField.setLayoutX(100);
        textField.setLayoutY(500);

        chart.setAnimated(false);
        chart.list.bindBidirectional(model.list);
        textField.setText("Test");

        textField.textProperty().bindBidirectional(label.textProperty());

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chart.change();
            }
        });

        root.getChildren().addAll(textField, chart, button,label);

        primaryStage.show();
    }
    @Override
    public void stop() throws Exception{
        super.stop();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }

}
