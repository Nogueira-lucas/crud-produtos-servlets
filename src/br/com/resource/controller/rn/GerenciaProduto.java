package br.com.resource.controller.rn;

import java.util.LinkedList;
import java.util.List;

import br.com.resource.model.Produto;
import br.com.resource.model.dao.ProdutoDAO;

public class GerenciaProduto {

	public static int cadastrarProduto(Produto produto) {
		List<Produto> lista = new ProdutoDAO().listarTodos();
		
		if(produto.getNome() == "" || produto.equals(null))
			return 2; //campo vazio
		
		for(Produto p: lista) {
			if(p.getNome().equals(produto.getNome())) {
				return 0; //ja existe
			}
		}
		new ProdutoDAO().salvar(produto);
		return 1; //salvou
	}
	
	public static List<String[]> gerarListaProdutos(){
		List<Produto> produtos = new ProdutoDAO().listarTodos();
		List<String[]> listaHTML = new LinkedList<>();
		String[] textos; 
		for(Produto produto: produtos) {
			textos = new String[4]; 
			textos[0] = String.valueOf(produto.getId());
			textos[1] = produto.getNome();
			textos[2] = produto.getFabricante();
			textos[3] = String.valueOf(produto.getValor());
			listaHTML.add(textos);
		}
		
		return listaHTML;
	}
}
