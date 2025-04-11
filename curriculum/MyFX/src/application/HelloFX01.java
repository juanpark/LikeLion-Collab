package application;

import javafx.scene.control.Button;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloFX01 extends Application {
	
	private Button createButton() {
		Button bt = new Button("Hello JavaFX 🎶");
		return bt;
	}


    @Override
    public void start(Stage stage) {
    	Button bt = createButton();
    	
        stage.setScene(new Scene(bt, 300, 500));
        stage.setTitle("JavaFX 테스트");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
