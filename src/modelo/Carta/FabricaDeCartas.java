package modelo.Carta;

import java.util.LinkedList;
import modelo.Deck;

/*
 * Esta e uma classe que gera um numero de cartas aleatorias a um deck
 */

public class FabricaDeCartas {
	
	static public Deck gerar(LinkedList<Carta> cartas, int numeroDeCartas){
		Deck d = new Deck();
		for(int i = 0; i<numeroDeCartas; i++){
			d.deck.add(cartas.get((int) (Math.random()*(cartas.size()))));
		}
		return d.clone();
	}
	
}
