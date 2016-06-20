package com.unisinos.redes.model;

public class Entrada {
	
	private int acao;
	private Usuario usuario;
	
	public Entrada(int acao, Usuario usuario) {
		this.acao = acao;
		this.usuario = usuario;
	}
	
	public Entrada() {
		
	}
	
	public int getAcao() {
		return acao;
	}

	public void setAcao(int acao) {
		this.acao = acao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String toString() {
		return acao + "," + usuario.toString();
	}
	
}
