package com.simuladorLogin;

import java.sql.SQLException;
import java.util.Scanner;

import com.simuladorLogin.dao.Dao;
import com.simuladorLogin.modelos.Usuario;
import com.simuladorLogin.dao.UsuarioDaoImpl;

public class GerenciadorUsuarios {

	private Scanner scanner = new Scanner(System.in);
	private Dao<Usuario> dao;
	
	public GerenciadorUsuarios() {
		dao = new UsuarioDaoImpl();
	}
	
	public void cadastrarUsuario() throws SQLException {
		
		String email = "";
		String senha = "";
		
		do{
			System.out.println("\n\t Cadastrando Usuário");
			System.out.println("\n\n Informe seu Email:");
			email = scanner.nextLine();
			
			System.out.println("\n Informe sua Senha: ");
			senha = scanner.nextLine();
		}while(!ValidadorDeUsuarios.validaEmail(email) || !ValidadorDeUsuarios.validaSenha(senha));
		
		dao.inserir(new Usuario(email, senha));
		System.out.println("\n Usuário Cadastrado com sucesso!");
	}
	
	public void atualizarSenha() {
		System.out.println("\n\t Atualizando Senha");
		System.out.println("\n\n Informe seu Email:");
		String email = scanner.nextLine();
		
		System.out.println("\n\n Informe a nova senha: ");
		String senha = scanner.nextLine();
		
		Usuario usuario = null;
		
		try {
			usuario = dao.get(email);
			dao.atualizar(email, new Usuario(email, senha));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(usuario == null) {
				System.err.println("\n\n Email não cadastrado!\n");
				return;
			}
		}
		
		System.out.println("\n Senha atualizada com sucesso!");
	}
	
	public void logarUsuario(){
		
		Usuario usuario = null; 
		
		System.out.println("\n\t Realizando Login");
		System.out.println("\n\n Informe seu Email:");
		String email = scanner.nextLine();
		
		System.out.println("\n Informe sua Senha: ");
		String senha = scanner.nextLine();
		
		try {
			usuario = dao.get(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(usuario == null) {
				System.err.println("\n\n Email não cadastrado!\n");
				return;
			}
		}
		
		if(!usuario.getSenha().equals(senha)) {
			System.err.println("\n\n Senha Incorreta!\n");
		}else {
			System.out.println("\n Login realizado com sucesso!");
		}
	}

}
