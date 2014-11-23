package modelo;

import java.util.HashMap;

import modelo.Carta.Carta;
import modelo.Carta.CartaMana;
import modelo.Carta.Monstro;

public class Campo {
	
	private HashMap<Jogador, AreaJogador> campo;
	
	public Campo(Jogador j1, Jogador j2){
		AreaJogador area1 =  new AreaJogador(j1);
		AreaJogador area2 =  new AreaJogador(j2);
		campo = new HashMap<Jogador, AreaJogador>();
		campo.put(j1, area1);
		campo.put(j2, area2);
		
	}
	
	public void moveParaDescarte(Carta c, Jogador j){
		campo.get(j).adicionaDescarte(c);
	}
	
	public void porEmCampo(Carta c, Jogador j) throws Exception{
		if(c instanceof Monstro){
			System.out.println("I... AM... A... MONSTER!!!");
			campo.get(j).adicionaMonstro((Monstro)c);
		}
		if(c instanceof CartaMana){
			campo.get(j).adicionaCartaMana((CartaMana)c);
		}
	}

}
