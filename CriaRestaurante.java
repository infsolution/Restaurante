package br.com.infsolution.restaurante.aplication;
import br.com.infsolution.restaurante.model.*;

public class CriaRestaurante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Restaurante restaurante = new Restaurante("Cajuina", 10);
		Mesa []unidas = new Mesa[2];
		Pedido p1 = new Pedido("Agua s/ gas", 2);
		Mesa x = restaurante.abrirMesa(10);
		
		x.adicionarPedido(p1);
		p1 = new Pedido("Skol", 12);
		x.adicionarPedido(p1);
		p1 = new Pedido("Skol", 12);
		x.adicionarPedido(p1);
		p1 = new Pedido("Skol", 12);
		x.adicionarPedido(p1);
		p1 = new Pedido("Skol", 12);
		x.adicionarPedido(p1);
		p1 = new Pedido("Skol", 12);
		x.adicionarPedido(p1);
		x.setComTaxa(true);
		
		x.setRateio(2);
		
		Mesa mesa2 = restaurante.abrirMesa(2);
		mesa2.adicionarPedido(new Pedido("Caviar", 323));
		
		Mesa mesa1 = restaurante.abrirMesa(1);
		mesa1.adicionarPedido(new Pedido("Picanha", 99.0));
		mesa1.adicionarPedido(new Pedido("Caldo", 3.00));
		mesa1.adicionarPedido(new Pedido("cerveja", 37.00));
		
		unidas = restaurante.juntar(mesa1, mesa2);
		System.out.println(mesa2.getSaldo());
		
		System.out.println(restaurante);
		
		for (Mesa mesa : restaurante.getMesas()) {
			if (mesa.getStatus() == Mesa.OCUPADA)
				System.out.println(mesa);
		}
		
		System.out.println(restaurante);
	}

	

}
