package com.simuladorLogin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorDeUsuarios {

	public static boolean validaEmail(String email) {
		
		boolean valida = email.matches("\\w+@[a-z]+\\.[a-z]{2,3}");
		
		if(!valida) {
			System.out.println("\n\n !!! Formato do Email não é válido !!!");
		}
		
		return valida;
	}
	
	public static boolean validaSenha(String senha) {
		
		boolean temMaiuscula = possuiPadrao(senha, "[A-Z]");
		boolean temMinuscula = possuiPadrao(senha, "[a-z]");
		boolean temSimbolo = possuiPadrao(senha, "\\W");
		boolean temNumero = possuiPadrao(senha, "\\d");
		boolean temOitoDigitos = senha.length() >= 8 ? true : false;
		
		boolean valida = senhaEstaCompativel(temMaiuscula, temMinuscula, temSimbolo, 
				                              temNumero, temOitoDigitos);
		
		System.out.print("\n\n");
		
		return valida;
	}
	
	private static boolean possuiPadrao(String senha, String regex) {
		
		Pattern padrao = Pattern.compile(regex);
		Matcher matcher = padrao.matcher(senha);
		return matcher.find();
	}
	
	private static boolean senhaEstaCompativel(boolean temMaiuscula, boolean temMinuscula,
	boolean temSimbolo, boolean temNumero, boolean temOitoDigitos) {
		
		boolean senhaCompativel = true;
		
		if(!temMaiuscula) {
			System.out.print("\n -A senha deve possuir letras Maiúsculas;");
			senhaCompativel = false;
		}
		
		if(!temMinuscula) {
			System.out.print("\n -A senha deve possuir letras Minúsculas;");
			senhaCompativel = false;
		}
		
		if(!temSimbolo) {
			System.out.print("\n -A senha deve possuir Símbolos (EX: !#$@%&*);");
			senhaCompativel = false;
		}
		
		if(!temNumero) {
			System.out.print("\n -A senha deve possuir Números;");
			senhaCompativel = false;
		}
		
		if(!temOitoDigitos) {
			System.out.print("\n -A senha deve possuir ao menos oito caracteres;");
			senhaCompativel = false;
		}
		
		return senhaCompativel;
	}
}
