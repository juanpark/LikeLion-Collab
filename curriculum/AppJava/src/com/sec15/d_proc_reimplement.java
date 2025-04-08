package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import static common.JDBCTemplate_BAK.*; // 자주 사용하는 정적 메소드를 클래스명 없이 참조해서 바로 호출!!!

public class d_proc_reimplement {

	public static void main(String[] args) {
		// 연결확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			String sql = "{ call PRO06_SELECTALL() } ";
			cstmt = conn.prepareCall(sql);
			rs = cstmt.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			// print column headers
			for (int i = 1; i <= columnCount; i++) {
				System.out.printf("%8s", metaData.getColumnLabel(i));
				if (i < columnCount) {
					System.out.print(" | ");
				}
			}
			System.out.println();
			/// 출력
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.printf("%8s", rs.getString(i));
					if (i < columnCount) {
						System.out.print(" | ");
					}
				}
				System.out.println();
//				int empno = rs.getInt("empno");
//				String name = rs.getString("ename");
//				int deptno = rs.getInt("deptno");
//
//				System.out.printf(" %5d %10s %5d \n", empno, name, deptno);

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
