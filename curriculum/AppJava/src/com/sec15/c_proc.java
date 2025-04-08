package com.sec15;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JDBCTemplate.*;

//사원번호와 이름을 입력받아 수정해보자. 3번의 이름을 홍길동으로 변경
public class c_proc {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 변경할 사원번호 : ");
		int empno = sc.nextInt();
		sc.nextLine(); // 떠돌이 \n 냠냠 - 개행제거
		System.out.print("변경할 이름 : ");
		String ename = sc.nextLine();
		
		// 연결확인 
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		
		try {
			String sql = "{ call PRO03_UPDATE(?,?) }";
			cstmt = conn.prepareCall(sql); // 구문 준비
			cstmt.setInt(1, empno); // 바인딩 
			cstmt.setString(2, ename); // 바인딩 
			
			cstmt.executeUpdate(); // 프로시저 실행
			System.out.printf("%d번 이름 %s로 변경했어!", empno, ename);
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
