package com.sec15;

import static common.JDBCTemplate.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class fibonacci_proc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("피보나치 몇개까지?: ");
		int place = sc.nextInt();
		
		// 연결확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		String sql = "{ call 05_Fibonacci_CTE(?) }";
		
		try {
			cstmt = conn.prepareCall(sql);
			
			// data binding
			cstmt.setInt(1, place); // IN
			
			// run
			rs = cstmt.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			// print column headers
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(metaData.getColumnLabel(i));
				if (i < columnCount) {
					System.out.print(" | ");
				}
			}
			System.out.println();
 			
			// display the results
			while (rs.next()) {
				// GuGuDan_PRN <- alias name of the column returned by the procedure
				int number = rs.getInt("항번호");
				int fibNumber = rs.getInt("피보나치 수열");
				System.out.printf("%3d\t%3d\n", number, fibNumber);
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







