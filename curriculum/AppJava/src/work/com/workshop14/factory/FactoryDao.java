package work.com.workshop14.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FactoryDao {
	void getFactoryAll(Connection con) {
		
		List<Map<String, Object>> result = new ArrayList<>();

		Statement stmt = null;
		ResultSet rs = null;
		
		Map<String, String> COLUMN_LABELS = Map.ofEntries(
			    Map.entry("FACTNO", "공장번호"),
			    Map.entry("FACNAME", "공장명"),
			    Map.entry("FACLOC", "공장위치")
			    );
		
		
		String sql = "SELECT * FROM FACTORY";
			
			
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			
			for (int i = 1; i <= columnCount; i++) {
			    String columnName = meta.getColumnLabel(i);
			    String header = COLUMN_LABELS.getOrDefault(columnName, columnName);
			    System.out.printf("%-20s", header);
			}
			System.out.println();
			System.out.println("----------------------------------------------------");
			
		      while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    Object value = rs.getObject(i);
                    System.out.printf("%-20s", value != null ? value.toString() : "NULL");
                }
                System.out.println();
		      }
              System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
