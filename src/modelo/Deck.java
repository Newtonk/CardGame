package modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import modelo.Carta.Carta;

public class Deck {

	public List<Carta> deck;

	public Deck() {
		deck = new LinkedList<Carta>();
	}
	
	public Deck(List<Carta> c) {
		this.deck = c;
	}
	
	public Carta sacar(){
		if (deck.size()!=0){
			Carta c = deck.remove(0);
			return c;
		}
		return null;
	}
	
	public void embaralhar(){
		LinkedList<Carta> embaralhado = new LinkedList<Carta>();
		Carta temp;
		Random emb = new Random();
		while(deck.size()>0){
			temp = deck.remove(emb.nextInt(deck.size()));
			embaralhado.add(temp);
		}
		deck = embaralhado;
	}

	// O m�todo clone serve para passar um novo deck a cada in�cio de partida.
	// Assim o deck concreto ficaria num "invent�rio" e voc� o editaria fora do
	// jogo. No in�cio da partida o jogador recebe um clone do deck. Assim,
	// qualquer modifica��o feita no clone ao decorrer da partida n�o vai efeito
	// no deck principal ao findar dela. Isso se deve pela passagem por
	// refer�ncia que Java for�a.
	public Deck clone() {
		List<Carta> d = new LinkedList<>();
		for (Carta c : deck)
			d.add(c.clone());
		return new Deck(d);
	}
	
	public String toString(){
		String s = "";
		for (int i = 0; i < deck.size(); i++){
			s = s + deck.get(i).toString()+" ";
		}
		return s;
	}

}
