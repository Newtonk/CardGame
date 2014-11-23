package modelo;

import java.util.LinkedList;

import modelo.Carta.Carta;
import modelo.Carta.CartaMana;
import modelo.Carta.Monstro;

public class AreaJogador {
	
	private Jogador dono;
	private LinkedList<Monstro> monstros;
	private LinkedList<Carta> descarte;
	private LinkedList<CartaMana> areaMana;
	private Deck deck;
	
	public AreaJogador(Jogador jogador){
		dono = jogador;
		deck = dono.getDeck();
		monstros = new LinkedList<Monstro>();
		descarte = new LinkedList<Carta>();
		areaMana = new LinkedList<CartaMana>();
	}
	
	public Jogador dono(){
		return dono;
	}
	
	public void adicionaDescarte(Carta c){
		descarte.add(c);
	}

	public void adicionaMonstro(Monstro c) throws Exception {
		// TODO Auto-generated method stub
		if(monstros.size()<4)
			monstros.add(c);
		else
			throw new Exception();
	}

	public void adicionaCartaMana(CartaMana c) throws Exception {
		// TODO Auto-generated method stub
		if(areaMana.size()<6)
			areaMana.add(c);
		else
			throw new Exception();
	}

}
