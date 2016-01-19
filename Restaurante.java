package br.com.infsolution.restaurante.model;

public class Restaurante {
	private String nome;
	private Mesa[] mesas;
	private Mesa[] juntas;
	
	public Restaurante(String nome, int qtdDeMesas) {
		this.nome = nome;
		this.mesas = new Mesa[qtdDeMesas];
		for (int i = 0; i < mesas.length; i++) {
			mesas[i] = new Mesa(i+1);
		}
	}
	
	public Mesa abrirMesa(int numero){
		Mesa m = this.mesas[numero-1];
		m.setStatus(Mesa.OCUPADA);
		return m;
	}
	
	public Mesa[] getMesas() {
		return mesas;
	}
	
	public String verSituacaoEValoresDasMesas(){
		int contDisponivel = 0;
		int contOcupada = 0;
		int contReservada = 0;
		double valorTotalAtual = 0;
		
		for (Mesa mesa : mesas) {
			if (mesa.getStatus() == Mesa.DISPONÍVEL)
				contDisponivel++;
			if (mesa.getStatus() == Mesa.OCUPADA)
				contOcupada++;
			if (mesa.getStatus() == Mesa.RESERVADA)
				contReservada++;
			
			valorTotalAtual += mesa.conta();
		}
		
		return "\n Mesas--> Ocupadas:  "+contOcupada+", Disponíveis:  "+contDisponivel
				+ ", Reservadas: " + contReservada
				+ "\n Valor Atual R$ " + valorTotalAtual;
	}
	
	public Mesa[] juntar(Mesa mesa1,Mesa mesa2){//Juntar mesas
		Mesa juntas[]= new Mesa[2];
		juntas[0]=mesa1;
		juntas[1]=mesa2;
		mesa1.setSituacao(Mesa.JUNTA);
		mesa2.setSituacao(Mesa.JUNTA);
		mesa1.setSaldo(mesa1.conta()+mesa2.conta());
		mesa2.setSaldo(mesa1.conta()+mesa2.conta());
		if (mesa1.getStatus() != Mesa.OCUPADA||mesa2.getStatus() != Mesa.OCUPADA){
			mesa1.setStatus(Mesa.OCUPADA);
			mesa2.setStatus(Mesa.OCUPADA);
		}
			return juntas;
	}


	
	@Override
	public String toString() {
		return "Restaurante: " + nome + ", Qtd Mesas: " + this.mesas.length + verSituacaoEValoresDasMesas();
	}

}
