package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class ConnectDB {

	static private final String jdbcUrl="jdbc:mysql://localhost/dizionario?user=root&password=root";
	
	static private HikariDataSource ds =null;
	
	public static Connection getConnection() {
		
		if(ds==null) {
			ds = new HikariDataSource();
			
			ds.setJdbcUrl(jdbcUrl);
		}
		
		try {
			Connection connection = ds.getConnection();
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Can't get a connection: "+jdbcUrl,e);
		}
		
		
	}
	
}
