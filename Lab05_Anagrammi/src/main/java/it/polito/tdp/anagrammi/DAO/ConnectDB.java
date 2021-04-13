package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	static private final String jdbcUrl="jdbc.mysql://localhost/dizionario?user=root&password=root";
	public static Connection getConnection() {
		Connection connection;
		try {
			connection = DriverManager.getConnection(jdbcUrl);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Can't get a connection: "+jdbcUrl,e);
		}
		
		
	}
	
}
