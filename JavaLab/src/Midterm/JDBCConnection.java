package Midterm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnection extends JavaIO {

	
	//JDBC登入
	public static Connection conn(String dburl, String username, String password) throws SQLException {

		Connection conn = DriverManager.getConnection(dburl, username, password);
		return conn;

	}
	
	
	//準備SQL語法
	public static PreparedStatement prepStat (Connection conn, String stat) throws SQLException {
		
		PreparedStatement prepStat = conn.prepareStatement(stat);
		return prepStat;
		

		
		
	}
	

}