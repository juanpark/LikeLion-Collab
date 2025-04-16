package work.com.workshop14.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// import work.com.workshop14.model.Product;
import static common.JDBCTemplate.*;


public class ProductDaoImpl implements ProductDao {

	// SELECT * FROM Product
	@Override
	public List<Map<String, Object>> selectAllProducts() {
		List<Map<String, Object>> result = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM PRODUCT";
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			
			while (rs.next()) {
				Map<String, Object> row = new LinkedHashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					String columnName = meta.getColumnLabel(i);
					Object value = rs.getObject(i);
					row.put(columnName, value);
				}
				result.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(stmt);
			Close(conn);
		}
			
		return result;
	}

	// 4-1번 문제
	/*
	SELECT P.PDNAME, P.PDSUBNAME, F.FACNAME, S.STONAME, S.STAMOUNT
	FROM PRODUCT P
	JOIN FACTORY F ON P.FACTNO = F.FACTNO
	JOIN STORE S ON P.PDNO = S.PDNO
	WHERE F.FACLOC = 'SEOUL' AND (S.STAMOUNT = 0 OR S.STAMOUNT IS NULL);
	*/
	@Override
	public List<Map<String, Object>> problem4_1() {
		List<Map<String, Object>> result = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = """
			SELECT P.PDNAME, P.PDSUBNAME, F.FACNAME, S.STONAME, S.STAMOUNT
	        FROM PRODUCT P
	        JOIN FACTORY F ON P.FACTNO = F.FACTNO
	        JOIN STORE S ON P.PDNO = S.PDNO
	        WHERE F.FACLOC = 'SEOUL'
	        AND (S.STAMOUNT = 0 OR S.STAMOUNT IS NULL)
		""";
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			
			while (rs.next()) {
				Map<String, Object> row = new LinkedHashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					String columnName = meta.getColumnLabel(i);
					Object value = rs.getObject(i);
					row.put(columnName, value);
				}
				result.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(stmt);
			Close(conn);
		}
			
		return result;
	}
	
	// 4-2번 문제
	/*
	SELECT PDSUBNAME, PDCOST, PDPRICE
	FROM PRODUCT
	WHERE (PDNAME = 'TV' 
	AND PDCOST > (
		SELECT MIN(PDCOST)
	    FROM PRODUCT
	    WHERE PDNAME = 'TV'))
	OR
	(PDNAME = 'CELLPHONE' 
	AND PDCOST < (
	SELECT MAX(PDCOST)
    FROM PRODUCT
    WHERE PDNAME = 'CELLPHONE')
	);
	 */
	@Override
	public List<Map<String, Object>> problem4_2() {
		List<Map<String, Object>> result = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = """
			SELECT PDSUBNAME, PDCOST, PDPRICE
			FROM PRODUCT
			WHERE (PDNAME = 'TV' 
			AND PDCOST > (
				SELECT MIN(PDCOST)
			    FROM PRODUCT
			    WHERE PDNAME = 'TV'))
			OR
			(PDNAME = 'CELLPHONE' 
			AND PDCOST < (
			SELECT MAX(PDCOST)
		    FROM PRODUCT
		    WHERE PDNAME = 'CELLPHONE')
			);
		""";
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			
			while (rs.next()) {
				Map<String, Object> row = new LinkedHashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					String columnName = meta.getColumnLabel(i);
					Object value = rs.getObject(i);
					row.put(columnName, value);
				}
				result.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(stmt);
			Close(conn);
		}
			
		return result;
	}

	// 4-3번문제
	@Override
	public String problem4_3() {
		Connection conn = getConnection();
		Statement stmt = null;
		
		try {
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet tables = meta.getTables(null, null, "DISCARDED_PRODUCT", null);
			
			if (tables.next()) {
				return "DISCARDED_PRODUCT 테이블이 이미 존재합니다";
			}
			String sql = """
				CREATE TABLE IF NOT EXISTS DISCARDED_PRODUCT (
	            PDNO INT PRIMARY KEY,
	            PDNAME VARCHAR(10),
	            PDSUBNAME VARCHAR(10),
	            FACTNO VARCHAR(5),
	            PDDATE DATE,
	            PDCOST INT,
	            PDPRICE INT,
	            PDAMOUNT INT,
	            DISCARDED_DATE DATE,
	            CONSTRAINT FK_DISCARDED_PRODUCT_FACTORY
	                FOREIGN KEY (FACTNO)
	                REFERENCES FACTORY(FACTNO)
	        );
			""";
		
			stmt = conn.createStatement();
			stmt.execute(sql);
			return "DISCARDED_PRODUCT 테이블이 생성되었습니다";
		} catch (SQLException e) {
				e.printStackTrace();
				return "테이블 생성 중 오류가 발생했습니다";
		} finally {
			Close(stmt);
			Close(conn);
		}
	}
	
	// 4-4번문제
	@Override
	public String problem4_4() {
		Connection conn = getConnection();
		Statement stmt = null;
		
		try {
			conn.setAutoCommit(false);
			
			String sql = """
				INSERT INTO DISCARDED_PRODUCT (
				PDNO, PDNAME, PDSUBNAME, FACTNO, PDDATE,
				PDCOST, PDPRICE, PDAMOUNT, DISCARDED_DATE
				)
				SELECT
				PDNO, PDNAME, PDSUBNAME, FACTNO, PDDATE,
				PDCOST, PDPRICE, PDAMOUNT, CURDATE()
				FROM PRODUCT
				WHERE FACTNO IN (
				SELECT FACTNO
				FROM FACTORY
				WHERE FACLOC = 'CHANGWON'
	        );
			""";
		
			stmt = conn.createStatement();
			int insertCount = stmt.executeUpdate(sql);
			
			conn.commit();
			
			return insertCount + "개의 데이터가 정상적으로 INSERT 되었습니다.";
		} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
				return "테이블 삽입 중 오류가 발생했습니다";
		} finally {
			Close(stmt);
			Close(conn);
		}
	}
	
	// 4-5번 문제
	@Override
	public String problem4_5() {
		Connection conn = getConnection();
		Statement stmt = null;
		
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.execute("SET SQL_SAFE_UPDATES = 0");
			
			String sql = """
				DELETE FROM DISCARDED_PRODUCT
				WHERE FACTNO = 98712;
			""";
		
			int deleteCount = stmt.executeUpdate(sql);
			stmt.execute("SET SQL_SAFE_UPDATES = 1");
			conn.commit();
			
			return deleteCount + "개의 데이터가 정상적으로 DELETE 되었습니다.";
		} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
				return "테이블 삭제 중 오류가 발생했습니다";
		} finally {
			Close(stmt);
			Close(conn);
		}
	}
	
	// SELECT * FROM Discarded_Product
	@Override
	public List<Map<String, Object>> selectAllDiscarded() {
		List<Map<String, Object>> result = new ArrayList<>();
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM DISCARDED_PRODUCT";
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			
			while (rs.next()) {
				Map<String, Object> row = new LinkedHashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					String columnName = meta.getColumnLabel(i);
					Object value = rs.getObject(i);
					row.put(columnName, value);
				}
				result.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(stmt);
			Close(conn);
		}
			
		return result;
	}

	@Override
	public String dropDiscarded() {
		Connection conn = getConnection();
		Statement stmt = null;
		
		try {
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet tables = meta.getTables(null, null, "DISCARDED_PRODUCT", null);
			
			if (!(tables.next())) {
				return "DISCARDED_PRODUCT 테이블이 없습니다.";
			}
			conn.setAutoCommit(false);
			
			String sql = """
				DROP TABLE DISCARDED_PRODUCT;
			""";
		
			stmt = conn.createStatement();
			stmt.execute(sql);
			
			conn.commit();
			
			if (!(tables.next())) {
				return "DISCARDED_PRODUCT 테이블이 drop 되었습니다.";
			} else {
				return "테이블 drop이 실패했습니다.";
			}
		} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
				return "테이블 drop 중 오류가 발생했습니다";
		} finally {
			Close(stmt);
			Close(conn);
		}
	}
	
}
