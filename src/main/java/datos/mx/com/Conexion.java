package datos.mx.com;

import java.sql.*;

public class Conexion {
	private static final String JDBC_URL = "";
	private static final String JDBC_USER = "";
	private static final String JDBC_PASS = "";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
	}
	
	public static void close(ResultSet rs) throws SQLException {
		rs.close();
	}
	
	public static void close(Statement stmt) throws SQLException {
		stmt.close();
	}
	
	public static void close(PreparedStatement pstmt) throws SQLException {
		pstmt.close();
	}
	
	public static void close(Connection cn) throws SQLException {
		cn.close();
	}

}
