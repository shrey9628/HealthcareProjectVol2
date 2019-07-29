package DAO;

import java.sql.*;

public class DBManager {
	
	
	private static Connection con;
	public static Connection getConnection()
	{
		
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","SYSTEM","shrey");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	return con;
}

}