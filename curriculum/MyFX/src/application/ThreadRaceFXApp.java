package application;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
     UI 애니메이션 	JavaFX 애니메이션이 비동기 라서 스레드가 필요없어 뺐어요
   네트워크 통신은 반드시  DB I/O  필요합니다. 
   수천 개 대량 작업을 할경우는 ExecutorService 또는 Task를 자바에서 사용하고 있어요 	
    
 */

public class ThreadRaceFXApp  extends Application {
	private static final String[] RUNNERS = {"😸 야옹이", "🐶 멍멍이", "🐤 병아리", "🐰 토끼", "🐢 거북이"};

    public void start(Stage stage) {
        Pane root = new Pane();
        int laneHeight = 50;

        for (int i = 0; i < RUNNERS.length; i++) {
            String name = RUNNERS[i];

            // 참가자 이름 라벨
            Label label = new Label(name);
            label.setLayoutX(10);
            label.setLayoutY(i * laneHeight + 10);

            // 이동 표시용 사각형
            Rectangle runner = new Rectangle(50, 20);
            runner.setLayoutX(80);
            runner.setLayoutY(i * laneHeight + 10);

            // 애니메이션 설정 (달리기 표시할 내용)
            TranslateTransition tt = new TranslateTransition();//객체를 x,y로  이동시키는 클라스
            tt.setNode(runner);
            tt.setDuration(Duration.seconds(1 + Math.random() * 3)); // 1~4초
            tt.setToX(400);
            tt.setOnFinished(e -> System.out.println("🎉 " + name + " 도착!"));

            tt.play();
            root.getChildren().addAll(label, runner);
        }

        Scene scene = new Scene(root, 550, 300);
        stage.setTitle("달리기");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
