package br.com.resource.controller.regranegocio;

import java.util.List;

public class App {
	public static void main(String[] args) {
		List<String[]> lista = GerenciaProduto.gerarListaProdutos();
		for(String[] texto : lista) {
			System.out.print(texto[0] + texto[1] + texto[2] + texto[3] + "\n");
		}
	}
}
