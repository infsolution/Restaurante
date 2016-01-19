package br.com.infsolution.restaurante.model;

public class Mesa {
	public final static String DISPONÍVEL = "Disponível";
	public final static String OCUPADA = "Ocupada";
	public final static String RESERVADA = "Reservada";
	private static final int MAX_PEDIDOS = 4;
	public static final String MASTER = "Master";
	public static final String SLAVE = "Slave";
	public static final String SOZINHA="Sozinha";
	public static final String JUNTA="Junta";
	private int numero;
	private String status;
	private Pedido[] pedidos;
	private int qtdMaximaDePedidosAtual = MAX_PEDIDOS;
	private int contadorDePedido = 0;
	private boolean comTaxa;
	private int rateio;
	private String situacao;
	private String tipo;
	private int numeMesaIrma;
	private double saldo;
	
	public Mesa(int numero) {
		this.numero = numero;
		this.status = Mesa.DISPONÍVEL;
		this.pedidos = new Pedido[qtdMaximaDePedidosAtual];
		this.comTaxa = true;
		this.tipo = Mesa.MASTER;
		this.situacao=Mesa.SOZINHA;
		
		
	}
	
	
	

	public void adicionarPedido(Pedido pedido){
		if (this.status != Mesa.OCUPADA){
			System.out.println("Favor abrir mesa primeiro");
			return;
		}
		
		pedidos[contadorDePedido++] = pedido;
		
		if (contadorDePedido == qtdMaximaDePedidosAtual){
			qtdMaximaDePedidosAtual += MAX_PEDIDOS;
			
			Pedido[] temp = this.pedidos;
			
			this.pedidos = new Pedido[qtdMaximaDePedidosAtual];
			
			for (int i = 0; i < temp.length; i++) {
				this.pedidos[i] = temp[i];
			}
			
			
		}
		
	} 
	
	public double conta(){
		double valor = 0;
		
		for (Pedido pedido : this.getPedidos()) {
			if (pedido == null) break;
			valor += pedido.getValor();
		}

		if (comTaxa)
			valor *= 1.1;
		
		return valor;
	}
	
	public void setPedidos(Pedido[] pedidos) {
		this.pedidos = pedidos;
	}


	public double getSaldo() {
		return saldo;
	}




	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public int getNumeMesaIrma() {
		return numeMesaIrma;
	}

	public void setNumeMesaIrma(int numeMesaIrma) {
		this.numeMesaIrma = numeMesaIrma;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNumero() {
		return numero;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public Pedido[] getPedidos() {
		return pedidos;
	}
	
	public void setComTaxa(boolean comTaxa) {
		this.comTaxa = comTaxa;
	}
	
	public void setRateio(int rateio) {
		this.rateio = rateio;
	}
	
	@Override
	public String toString() {
		String str = "\n\nMesa " +numero 
				+ " - Pedidos Realizados: " + this.contadorDePedido + "\n"
				+ " Descricao \t\t Valor \n ------------------------- \n";
				for (Pedido pedido : pedidos) {
					if (pedido==null) break;
					str+=pedido.getDescricao()+"\t\t"+pedido.getValor()+"\n";
				}
				str += "-------------------------\n";
				str += "Valor Conta R$ " + conta();
				
				if (this.rateio > 1){
					str += "\nRateio R$ " + conta()/rateio;
				}
		
		return str;
	}
}
