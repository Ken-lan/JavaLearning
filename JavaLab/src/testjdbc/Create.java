package testjdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Create {
	public static void main(String[] args) throws Exception {

		// Java IO
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("C:\\Users\\Student\\Desktop\\A.csv")));

		br.readLine();
		String tempString;

		//JDBC
		Connection conn = DriverManager.getConnection(
				"jdbc:sqlserver://localhost:1433;database=TestCsv;user=sa;password=1234;trustServerCertificate=true;");
		PreparedStatement preState = conn.prepareStatement("INSERT INTO [dbo].[Test] VALUES(?,?,?,?)");

		while ((tempString = br.readLine()) != null) {
			String[] stringArray = tempString.split(",");
			preState.setString(1, stringArray[0]);
			preState.setString(2, stringArray[1]);
			preState.setString(3, stringArray[2]);
			preState.setString(4, stringArray[3]);
			
			preState.execute();
		}

		preState.close();
		conn.close();
		br.close();
	}
}
