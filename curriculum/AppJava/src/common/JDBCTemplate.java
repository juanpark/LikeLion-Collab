package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTemplate {

	// DB 연결 하는 곳
	public static Connection getConnection() {
	Connection conn = null;
	try {
		
		String url = "jdbc:mysql://127.0.0.1:3306/my_emp?";
		String user = "mydb";
		String password = "admin1234";
		
	    conn = DriverManager.getConnection(url, user, password);

	    if(!conn.isClosed()) {
	    	System.out.println("연결 중이야");
	    }
	} catch (Exception e) {
		System.out.println(e);
	}
	return conn;
	
	}
	
	// 1. DB close 하는 곳
	public static void Close(Connection con) {
		
		if(con != null) {
			try {
				con.close();
				// con = null; // non-static인 경우 활용
			} catch (SQLException e) {
				// e.printStackTrace();
				System.out.println("데이터베이스 연결 닫기 오류 :" + e.getMessage() + "\t" + e.getMessage());
			} // try - catch end
		} // if end
	} // Close() method end
	
	// 2. Statement close 하는 곳
	public static void Close(Statement stmt) {
		
		if(stmt != null) {
			try {
				stmt.close();
				
			} catch (SQLException e) {
				// e.printStackTrace();
				System.out.println("명령 오류 :" + e.getMessage() + "\t" + e.getMessage());
			} // try - catch end
		} // if end
	} // Close() method end
	
	// 3. ResultSet close 하는 곳
	public static void Close(ResultSet rs) {
		
		if(rs != null) {
			try {
				rs.close();

			} catch (SQLException e) {
				// e.printStackTrace();
				System.out.println("쿼리 리턴 오류 :" + e.getMessage() + "\t" + e.getMessage());
			} // try - catch end
		} // if end
	} // Close() method end
}
