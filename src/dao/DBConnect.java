package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private final static String host = "jdbc:mysql://localhost:3306/crud-jdbc?useSSL=false";
	private final static String usuario = "root";
	private final static String senha = "123456";
	
	public static Connection  conectar() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(host,usuario,senha);
		//System.out.println("Conectado!");
		return conn;
	}
	
	
	
}
