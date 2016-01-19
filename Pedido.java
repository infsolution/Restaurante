package br.com.infsolution.restaurante.model;

public class Pedido {
	private double valor;
	private String descricao;
	
	public Pedido(String descricao, double valor) {
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.descricao + "\t\t" + this.valor;
	}
}
