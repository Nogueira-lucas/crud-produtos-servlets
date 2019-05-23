package br.com.resource.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.com.resource.model.Produto;

public class ProdutoDAO {
	private Connection conn = null;
	
	public ProdutoDAO() {
		conn = FabricaConexao.getConexao();
	}
	
	public void salvar(Produto produto) {
		String sql = "INSERT INTO produtos(nome, fabricante, valor) VALUES(?,?,?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getFabricante());
			pstm.setBigDecimal(3, produto.getValor());
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void alterar(Produto produto) {
		String sql = "update produtos set nome=?, fabricante=?, valor=? where id=?; ";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, produto.getNome());
			pstm.setString(2, produto.getFabricante());
			pstm.setBigDecimal(3, produto.getValor());
			pstm.setInt(4, produto.getId());
			pstm.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public void excluir(Produto produto) {
		String sql = "DELETE FROM produtos WHERE(id=?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, produto.getId());
			pstm.execute();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			FabricaConexao.fecharConexao(conn, pstm);
		}
	}
	
	public List<Produto> listarTodos(){
		String sql = "SELECT * FROM produtos;";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Produto produto = null;
			List<Produto> produtos = new LinkedList<>();
			while(rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setFabricante(rs.getString("fabricante"));
				produto.setValor(rs.getBigDecimal("valor"));
				produtos.add(produto);
			}
			return produtos;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
	
	public Produto buscarPorId(int id) {
		String sql =  "SELECT (id, nome, fabricante, valor) FROM produtos WHERE(id=?);";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			Produto produto = null;
			
			produto = new Produto();
			produto.setId(rs.getInt("id"));
			produto.setNome(rs.getString("nome"));
			produto.setFabricante(rs.getString("fabricante"));
			produto.setValor(rs.getBigDecimal("valor"));
			
			return produto;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			FabricaConexao.fecharConexao(conn, pstm, rs);
		}
	}
}
