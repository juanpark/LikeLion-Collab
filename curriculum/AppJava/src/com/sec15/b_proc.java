package com.sec15;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.CallableStatement;

import static common.JDBCTemplate.*; //자주 사용하는 정적 메서드를 클래스명 없이 참조해서 바로 호출!

public class b_proc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 사원번호 : ");
		int empno = sc.nextInt();
		
		// 연결확인 
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		
		try {
			String sql = "{ call PRO02_DELETE(?) }";
			cstmt = conn.prepareCall(sql); // 구문 준비
			cstmt.setInt(1, empno); // 바인딩 
			
			cstmt.executeUpdate(); // 프로시저 실행
			System.out.println("삭제 했어!");
			commit(conn);
			
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			sc.close();
			Close(cstmt);
			Close(conn);		
			}
		
		
		
		
	}// main
}// class a_proc
