package com.simuladorLogin.modelos;

public class Usuario {

	private String email;
	private String senha;
	
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public String getEmail() {
		return this.email;
	}
	public String getSenha() {
		return this.senha;
	}
}
