package br.com.resource.model;

import java.math.BigDecimal;

public class Produto {
	private int id;
	private String nome;
	private String fabricante;
	private BigDecimal valor;
	
	public Produto() {}
	
	public Produto(int id, String nome, String fabricante, BigDecimal valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.fabricante = fabricante;
		this.valor = valor;
	}
	
	
	public Produto(String nome, String fabricante, BigDecimal valor) {
		super();
		this.nome = nome;
		this.fabricante = fabricante;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
