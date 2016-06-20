package com.unisinos.redes.main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.unisinos.redes.model.Entrada;
import com.unisinos.redes.model.Usuario;

public class ClienteTCP {

	public static void main(String[] args) {
		try {
			// Criado o cliente na porta 12345
			Socket cliente = new Socket("localhost", 12345);
			
			// Usuário insere os dados 
			Entrada entrada = usuarioInsereDados();
			
			enviaDadosAoServidor(entrada, cliente);
			
			recebeDadosDoServidor(cliente);
			
			// Encerra o cliente
			cliente.close();
			System.out.println("Cliente encerrado.");
		} catch (Exception e) { 
			e.printStackTrace();
			System.out.println("Ocorreu um erro durante a execução: " + e.getMessage());
		}
	}

	private static void enviaDadosAoServidor(Entrada entrada, Socket cliente) throws IOException {
		ObjectOutputStream outputStream = new ObjectOutputStream(cliente.getOutputStream());
		outputStream.writeObject(entrada.toString());
		outputStream.flush();
	}
	
	/**
	 * Cliente lê a resposta e mostra ao usuário 
	 * @param cliente
	 * @throws Exception
	 */
	public static void recebeDadosDoServidor(Socket cliente) throws Exception {
		ObjectInputStream inputStream = new ObjectInputStream(cliente.getInputStream());
		String resposta = (String) inputStream.readObject();

		// mostra resposta ao usuário
		System.out.println(resposta);
		
		// encerra a conexão
		inputStream.close();
	}
	
	private static Entrada usuarioInsereDados() {
		Scanner scanner = new Scanner(System.in);
		Entrada entrada = new Entrada();
		Usuario usuario = new Usuario();
		
		System.out.println("Determine qual ação você deseja realizar:");
		System.out.println("1 - Validar usuário e senha");
		System.out.println("2 - Cadastrar usuário e senha");
		int acao = scanner.nextInt();
		entrada.setAcao(acao);

		System.out.print("username: ");
		String username = scanner.next();
		usuario.setUsername(username);
		
		System.out.println("senha: ");
		String senha = scanner.next();
		usuario.setSenha(senha);
		
		entrada.setUsuario(usuario);
		
		scanner.close();
		
		return entrada;
	}
}
