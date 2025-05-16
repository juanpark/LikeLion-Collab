package common;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class JDBCTemplate {
	private static String url, user, password;

	// 드라이버 셋팅 , 연결 준비
	static { // static 생성자 역할 -> 정적 메모리 확보를 제일 먼저 실행되고 바인드된다.
		try (InputStream is = JDBCTemplate.class.getClassLoader().getResourceAsStream("db.properties")) {
			Properties prop = new Properties(); // 속성들을 담을 객체
			prop.load(is);// Reads a property list (key and element pairs) from the inputbyte stream.

			url = prop.getProperty("url"); // key를 호출하면 값을 리턴
			user = prop.getProperty("user");
			password = prop.getProperty("password");

			Class.forName(prop.getProperty("driver"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DB 연결
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			return conn; // return 은 메소드를 종료하는 키워드

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void close(AutoCloseable ac) {
		try {
			if (ac != null)
				ac.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection conn) {
		try {
			if (conn != null)
				conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			if (conn != null)
				conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}