package br.com.resource.controller.regranegocio;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.resource.model.Produto;
import br.com.resource.model.dao.ProdutoDAO;

public class GerenciaProduto {

	public static String cadastrarProduto(Produto produto) {
		List<Produto> lista = new ProdutoDAO().listarTodos();
		
		if(produto.getNome().equals("") || produto.equals(null) ||
				produto.getFabricante().equals("")||
				produto.getValor().equals(""))
			return "Campo vazio";
		
		for(Produto p: lista) {
			if(p.getNome().equals(produto.getNome())) {
				return "Já existe um produto com mesmo nome";
			}
		}
		
		try {
			new ProdutoDAO().salvar(produto);
			return "Cadastro efetuado com sucesso!";
		}catch(Exception ex) {
			ex.printStackTrace();
			return "Não foi possível cadastrar";
		}
		
		
	}
	
	public static String atualizarProduto(Produto produto) throws SQLException {
		if(produto.getNome() == "" || produto.equals(null))
			return "Impossível atualizar - Motivo : Sem nome"; //campo vazio
		
		try {
			new ProdutoDAO().alterar(produto);
			return "Produto Atualizado com sucesso!";
		}catch (Exception e) {
			e.printStackTrace();
			return "Não foi possível atualizar";
		}
		
	}
	
	public static String excluirProduto(Produto produto) throws SQLException {
		if(produto.getNome() == "" || produto.equals(null))
			return "Impossível excluir - Motivo : sem parametros";//campo vazio
		try {
			new ProdutoDAO().excluir(produto);
			return "Produto Excluido com sucesso!";
		}catch (Exception e) {
			return "Não foi possivel excluir";
		}

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
