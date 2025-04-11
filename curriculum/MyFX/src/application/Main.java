package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        System.out.println("✅ start() method entered");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 400);

        // Comment this out for now
        // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Window Test");
        primaryStage.show();

        System.out.println("✅ primaryStage.show() called");
    }

    public static void main(String[] args) {
        System.out.println("▶️ launch() called");
        launch(args);
    }
}