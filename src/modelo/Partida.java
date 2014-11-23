package modelo;

import java.util.LinkedList;

public class Partida {
	private final int MANATURNO = 1;
	Campo batalha;
	public LinkedList<Jogador> jogadores;
		
	public Partida(LinkedList<Jogador> j, Campo c) {
		jogadores = j;
		this.batalha = c;
	}

	public void executaTurno() {
		Jogador j = proximo();
		j.adicionaMana(MANATURNO);
		j.sacar();
		System.out.println(j);
	}
	
	private Jogador proximo(){
		Jogador j = jogadores.remove(0);
		jogadores.add(j);
		return j;
	}

}
