package common;

import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

public class JDBCTemplate {
    private static String url, user, password;
    static {
        try (InputStream is = JDBCTemplate.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            prop.load(is);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            Class.forName(prop.getProperty("driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void close(AutoCloseable ac) {
        try { if (ac != null) ac.close(); } catch (Exception e) {}
    }
    public static void commit(Connection conn) {
        try { if (conn != null) conn.commit(); } catch (Exception e) {}
    }
    public static void rollback(Connection conn) {
        try { if (conn != null) conn.rollback(); } catch (Exception e) {}
    }
}