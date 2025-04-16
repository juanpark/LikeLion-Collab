package work.com.workshop14.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryBiz {
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	public FactoryBiz(String driver, String url, String user, String pass) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;
	}
	
	public void getFactoryall( ) {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
			FactoryDao dao = new FactoryDao();
			dao.getFactoryAll(conn);
			
		} catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 오류");
		} catch(SQLException e) {
			System.out.println("DB 연결 오류");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}
	
}
