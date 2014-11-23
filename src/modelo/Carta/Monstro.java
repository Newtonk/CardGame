package modelo.Carta;

import modelo.Jogador;

/*
 * Esta classe representa uma carta do tipo "Monstro"
 */

public class Monstro extends Carta{
	
	private int vidaMaxima;
	private int vidaAtual;
	private int ataque;
	private Elemento elemento;
	

	public Monstro(String nome, Elemento e, int custo, int atq, int vida){
		super(nome,custo);
		vidaMaxima = vidaAtual = vida;
		ataque = atq;
		elemento = e;
	}
	
	//Modificado para um boolean que informa a Partida/Sistema sobre
	//a morte do monstro
	public boolean verificaMorte(){
		return (vidaAtual <= 0 );
	}
	
	public Elemento elemento(){
		return elemento;
	}
	
	public void defende(Integer dano){
		vidaAtual = vidaAtual - dano;		
	}
	
	//Adicionada a efetividade dos elementos
	public void ataca(Monstro m){
		if(elemento.forteContra(m.elemento()))
			m.defende(ataque*2);
		else
			m.defende(ataque);
	}
	
	public void ataca(Jogador j){
		Integer vidaAntes =  j.getHp();
		//j.setHP(vidaAntes - ataque);
	}
	
	public void recuperaVida(Integer valor){
		vidaAtual+= valor;
		if(vidaAtual > vidaMaxima){
			vidaAtual = vidaMaxima;
		}
	}
	
}

