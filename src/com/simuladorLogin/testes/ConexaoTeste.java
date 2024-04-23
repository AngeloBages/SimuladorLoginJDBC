package com.simuladorLogin.testes;

import java.sql.Connection;
import java.sql.SQLException;

import com.simuladorLogin.ConnectionFactory;

public class ConexaoTeste {

	public static void main(String[] args) {
		
		Connection connection = ConnectionFactory.getConnection();
		
		System.out.println("Conexão estabelecida");
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
