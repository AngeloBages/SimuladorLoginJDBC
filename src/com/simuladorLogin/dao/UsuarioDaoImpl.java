package com.simuladorLogin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simuladorLogin.ConnectionFactory;
import com.simuladorLogin.modelos.Usuario;

public class UsuarioDaoImpl implements Dao<Usuario>{
	
	Connection connection;
	
	public UsuarioDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Usuario usuario) throws SQLException {
		
		String sql = "INSERT INTO usuarios (email, senha) VALUES (?, ?)";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			
			stm.setString(1, usuario.getEmail());
			stm.setString(2, usuario.getSenha());
			
			stm.execute();
		}
	}

	@Override
	public Usuario get(Object email) throws SQLException {
		
		String sql = "SELECT * FROM usuarios WHERE email = ?";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			
			stm.setString(1, (String) email);
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				
				String email_us = rs.getString("email");
				String senha = rs.getString("senha");
				
				return new Usuario(email_us, senha);
			}
		}
		return null;
	}

	@Override
	public List<Usuario> getList() throws SQLException {
		
		List<Usuario> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM usuarios";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				
				lista.add(new Usuario(email, senha));
			}
		}
		return lista;
	}

	@Override
	public void atualizar(Object email, Usuario usuario) throws SQLException {

		String sql = "UPDATE usuarios SET senha = ? WHERE email = ?";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			
			stm.setString(1, usuario.getSenha());
			stm.setString(2, (String) email);
			
			stm.execute();
		}
		
	}

	@Override
	public void delete(Object email) throws SQLException {

		String sql = "DELETE FROM usuarios WHERE email = ?";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			
			stm.setString(1, (String) email);
			stm.execute();
		}
	}
}
