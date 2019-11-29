package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Model myModel = new Model();

        //System.out.println("Sine of " + Math.tan(Math.toRadians(10)) * 22);

        Controller controller = new Controller();
        controller.setModel(myModel);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));


        primaryStage.setTitle("Vector calculator");
        primaryStage.setScene(new Scene((ScrollPane) loader.load()));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
