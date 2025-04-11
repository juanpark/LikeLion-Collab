package application;

import javafx.scene.control.Button;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//이름, 주소, 전화번호를 받아서 버튼을 클릭하면 입력한 내용을 출력해보자.
public class HelloFX02 extends Application {

    @Override
    public void start(Stage stage) {
    	// UI 구성 요소
    	Label lb_name = new Label("이름 :");
    	TextField tx_name = new TextField();
    	
    	Label lb_addr = new Label("주소 :");
    	TextField tx_addr = new TextField();
    	
    	Label lb_phone = new Label("전화번호 :");
    	TextField tx_phone = new TextField();
    	
    	Button bt = new Button ("확인");
    	Button bt_cancel = new Button ("취소");
    	
    	Label res_message = new Label(); // 출력할 내용 결과
    	
    	
    	// 버튼을 클릭했들 때 이벤트 발생 코드를 작성하자
    	bt_cancel.setOnAction(e-> {
    		tx_name.setText("");
    		tx_addr.setText("");
    		tx_phone.setText("");
    		res_message.setText("");
    	});
    	
    	
    	// handle(T event)
    	bt.setOnAction(e->{
    		// 명령 수행 코드
    		String res_name = tx_name.getText();
    		String res_addr = tx_addr.getText();
    		String res_phone = tx_phone.getText();
    		
    		String format_res = String.format("입력한 내용:\n이름: %10s\n주소: %10s\n전화번호: %10s\n", 
    											res_name, res_addr, res_phone);
    		res_message.setText(format_res);
    		
    	});
    	// layout 구성
//    	VBox root = new VBox();
//    	root.getChildren().addAll(
//			lb_name, tx_name,
//			lb_addr, tx_addr,
//			lb_phone, tx_phone,
//			bt, bt_cancel, res_message
//    	);
    	
    	HBox root = new HBox();
    	root.getChildren().addAll(
			lb_name, tx_name,
			lb_addr, tx_addr,
			lb_phone, tx_phone,
			bt, bt_cancel, res_message
    	);
    	
    	root.setSpacing( 10.0d );
    	root.setAlignment(Pos.CENTER);
    	root.setPadding(new Insets(10));
    	
        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("JavaFX 테스트");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
