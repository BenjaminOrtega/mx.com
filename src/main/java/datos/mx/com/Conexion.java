package datos.mx.com;

import java.sql.*;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "";
	
	public static DataSource getDataSource () {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl(JDBC_URL);
		basicDataSource.setUsername(JDBC_USER);
		basicDataSource.setPassword(JDBC_PASS);
		//definimos el numero inical de conexiones
		basicDataSource.setInitialSize(5);
		return basicDataSource;
	}	
	
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
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
