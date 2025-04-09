package com.sec15;

import static common.JDBCTemplate.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class getEmpResult_proc {
	public static void main(String[] args) {
		
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		

		
		try {
			String sql = "{ CALL 01_GetEmp_Res() }";
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
			System.out.println("------------------------------------------");
			// 출력
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.printf("%8s", rs.getString(i));
					if (i < columnCount) {
						System.out.print(" | ");
					}
				}
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(cstmt);
			Close(conn);
		}
	}
}
