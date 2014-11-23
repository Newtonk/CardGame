package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Carta.Carta;

public class Jogador {
	
	private int MAXMANA = 10;
	
	private int hp;
	private int mana;
	private List<Carta> mao;
	private Deck d;
	private String nome;

	public Jogador(String nome, Deck d) {
		this.nome = nome;
		hp = 20;
		mana = 3;
		mao =  new ArrayList<>(7);
		this.d = d;
		for(int i = 0; i<7; i++){
			mao.add(d.sacar());
		}
	}

	public int getHp() {
		return hp;
	}
		
	public int getMana() {
		return mana;
	}
	
	public Deck getDeck(){
		return d;
	}

	public void adicionaMana(int mana) {
		this.mana += mana;
	}

	public void adicionaHP(int hp) {
		this.hp += hp;
	}
	
	public void diminuiHP(int valor){
		hp -= valor;
	}
	
	public void adicionaNaMao(Carta c) {
		mao.add(c); // Adiciona uma carta a mao do jogador

	}

	public void iniciarSelecao() {
		mao.isEmpty(); // Verifica se a mao esta vazia, se estiver retorna
						// verdadeiro
	}

	public Carta escolheCarta() {
		double i = Math.random() * mao.size(); // Gera uma posicao aleatorio da
												// mao do jogador
		int posicao = (int) i; // Pega o valor inteiro gerado
		return mao.get(posicao); // Pega a Carta da posicao gerada
	}
	
	public void escolheCarta(int i) {
		try {
			mao.get(i); // Escolhe a carta da posicao i da mao do jogador
		} catch (Exception e) {

		}
	}
	
	public void embaralharDeck(){
		d.embaralhar();
	}

	public void retirarTopo() {
		mao.remove(0); // Remove a 1 carta da mao do jogador
	}

	public void sacar(){
		if(mao.size()<7){
			mao.add(d.sacar());
		}
	}
	
	public void removerDaMao(Carta c) {
		try {
			mao.remove(c);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Carta n�o existente no deck");
		}
	}

	/*
	 * public void colocaEmCampo(Carta c ){ mao.contains(c); c. }
	 */
	public void selecionaCarta(Carta c) {
		mao.get(mao.indexOf(c)); // Retorna a Carta
	}
	
	public String toString(){
		String s = "";
		for (int i = 0; i < mao.size(); i++){
			s = s + mao.get(i).toString()+" ";
		}
		return nome+":\n"+hp+" "+mana+"\nN�mero de cartas:"+mao.size()+"\nCartas:\n"+s;
	}
}
