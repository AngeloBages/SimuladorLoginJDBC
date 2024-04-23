package com.simuladorLogin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	public static Connection getConnection() {
		
		Connection connection;
		
		Properties p = new Properties();
		InputStream is = ConnectionFactory.class.getResourceAsStream("resources/conexaoJdbc.properties");
		
		try {
			p.load(is);
			connection = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("senha"));
		} catch (SQLException | IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return connection;
	}
}
