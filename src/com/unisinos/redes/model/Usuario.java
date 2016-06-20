package com.unisinos.redes.model;

public class Usuario {

	private String username;
	private String senha;

	public Usuario(String username, String senha) {
		this.username = username;
		this.senha = senha;
	}
	
	public Usuario() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String toString() {
		return username + "," + senha;
	}
}
