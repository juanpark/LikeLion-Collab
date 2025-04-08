package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static common.JDBCTemplate_BAK.*; // 자주 사용하는 정적 메소드를 클래스명 없이 참조해서 바로 호출!!!

public class d_proc {

	public static void main(String[] args) {
		// 연결확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			String sql = "{ call PRO06_SELECTALL() } ";
			cstmt = conn.prepareCall(sql);
			rs = cstmt.executeQuery();

			/// 출력
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String name = rs.getString("ename");
				int deptno = rs.getInt("deptno");

				System.out.printf(" %5d %10s %5d \n", empno, name, deptno);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(cstmt);
			Close(conn);
		}
	}
}
