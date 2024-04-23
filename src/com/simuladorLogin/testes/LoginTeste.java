package com.simuladorLogin.testes;

import java.sql.SQLException;
import java.util.Scanner;

import com.simuladorLogin.GerenciadorUsuarios;

public class LoginTeste {

	private GerenciadorUsuarios gu = new GerenciadorUsuarios();
	private Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		new LoginTeste().iniciar();
	}
	
	public void iniciar() {
		
		final int SAIR = 0;
		int opcao = Integer.SIZE;
		
		while(opcao != SAIR) {
			System.out.println("\n\t\tPLATAFORMA VIRTUAL GENÉRICA");
			System.out.println("\n\n [1]-Cadastrar");
			System.out.println(" [2]-Logar");
			System.out.println(" [3]-Atualizar Senha");
			System.out.println(" [0]-Sair");
			opcao = Integer.parseInt(scanner.nextLine());
			
			try {
				
				switch(opcao) {
				
					case 1:
						gu.cadastrarUsuario();
						break;
						
					case 2:
						gu.logarUsuario();
						break;
						
					case 3:
						gu.atualizarSenha();
						break;
						
					case 0:
						System.out.println("\n\n SAINDO... \n");
						break;
						
					default:
						System.out.println("\n\n ALTERNATIVA INVÁLIDA \n");
						break;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
