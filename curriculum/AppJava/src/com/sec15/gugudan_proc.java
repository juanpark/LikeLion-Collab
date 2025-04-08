package com.sec15;

import static common.JDBCTemplate.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class gugudan_proc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("구구단 몇단: ");
		int place = sc.nextInt();
		
		// 연결확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		String sql = "{ call 03_GuGuDan(?) }";
		
		try {
			cstmt = conn.prepareCall(sql);
			
			// data binding
			cstmt.setInt(1, place); // IN
			
			// run
			rs = cstmt.executeQuery();
 			
			// display the results
			while (rs.next()) {
				// GuGuDan_PRN <- alias name of the column returned by the procedure
				String line = rs.getString("GuGuDan_PRN");
				System.out.println(line);
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







