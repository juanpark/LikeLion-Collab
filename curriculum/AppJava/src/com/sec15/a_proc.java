package com.sec15;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;

import static common.JDBCTemplate_BAK.*; //자주 사용하는 정적 메서드를 클래스명 없이 참조해서 바로 호출!

public class a_proc {
	public static void main(String[] args) {
		// 연결확인 
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		
		try {
			String sql = "{ call PRO01_INSERT() }";
			cstmt = conn.prepareCall(sql);
			
			cstmt.execute(); // 프로시저 실행
			commit(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rollback(conn);
			e.printStackTrace();
		} finally {
			Close(cstmt);
			Close(conn);		
			}
		
		
		
		
	}// main
}// class a_proc
