package com.sec15;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static common.JDBCTemplate.*;

public class a_proc {
	public static void main(String[] args) {
		// 연결확인 
		Connection conn = getConnection();
		
		try {
			System.out.println(conn.isClosed());
			System.out.println("연결중......");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Close(conn);		}
		
		
		
		
	}// main
}// class a_proc
