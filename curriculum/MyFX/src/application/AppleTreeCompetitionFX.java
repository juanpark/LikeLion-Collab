package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AppleTreeCompetitionFX extends Application {

    private final Label catLabel = new Label("🐱 야옹이: 0개");
    private final Label dogLabel = new Label("🐶 멍멍이: 0개");
    private final Label remainingLabel = new Label("🍎 남은 사과: 100개");

    private int apples = 100;
    private int catCount = 0;
    private int dogCount = 0;

    private final Object lock = new Object();

    @Override
    public void start(Stage primaryStage) {
        Button startButton = new Button("🍏 게임 시작!");

        startButton.setOnAction(e -> {
            startButton.setDisable(true); // 중복 클릭 방지
            startCompetition();
        });

        VBox root = new VBox(15, startButton, remainingLabel, catLabel, dogLabel);
        root.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-font-size: 16px;");

        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.setTitle("🐱 vs 🐶 사과 따기 경쟁");
        primaryStage.show();
    }

    private void startCompetition() {
        Thread catThread = new Thread(() -> pickApple("야옹이"));
        Thread dogThread = new Thread(() -> pickApple("멍멍이"));

        catThread.start();
        dogThread.start();
    }

    private void pickApple(String who) {
        while (true) {
            boolean done;
            synchronized (lock) {
                if (apples <= 0) break;

                apples--;
                if (who.equals("야옹이")) catCount++;
                else dogCount++;

                int localApples = apples;
                int localCat = catCount;
                int localDog = dogCount;

                Platform.runLater(() -> {
                    catLabel.setText("🐱 야옹이: " + localCat + "개");
                    dogLabel.setText("🐶 멍멍이: " + localDog + "개");
                    remainingLabel.setText("🍎 남은 사과: " + localApples + "개");
                });
                done = localApples == 0;
            }

            try {
                Thread.sleep((long) (Math.random() * 50));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (done) {
                Platform.runLater(this::showResultDialog);
                break;
            }
        }
    }

    private void showResultDialog() {
        String winner;
        if (catCount > dogCount) winner = "🐱 야옹이 승리!";
        else if (dogCount > catCount) winner = "🐶 멍멍이 승리!";
        else winner = "🤝 무승부!";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("게임 결과");
        alert.setHeaderText(null);
        alert.setContentText("🐱: " + catCount + "개\n🐶: " + dogCount + "개\n\n" + winner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
