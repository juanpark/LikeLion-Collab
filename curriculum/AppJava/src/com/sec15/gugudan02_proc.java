package com.sec15;

import static common.JDBCTemplate.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class gugudan02_proc {
	public static void main(String[] args) {
		
		// 연결확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		String sql = "{ call 02_GuGuDan() }";
		
		try {
			cstmt = conn.prepareCall(sql);
			
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







