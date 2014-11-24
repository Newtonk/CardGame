package modelo;

import java.io.IOException;
import java.util.LinkedList;

import recursos.CardLoader;
import modelo.Carta.FabricaDeCartas;

/*
 * Esta classe sera a FACHADA do projeto e sera um SINGLETON
 */
public class Sistema {
	
	// SINGLETON
	private static Sistema sistema;
	private Sistema(){
	}
	public static Sistema getSistema (){
		if (sistema == null){
			sistema = new Sistema();
		}
		return sistema;
	}

	/*
	 * Teste do programa
	 */
	public void executeTest(){
		/*
		int nCartas = 50;
		Deck dOne = FabricaDeCartas.gerar(new Deck(), nCartas);
		Deck dTwo = FabricaDeCartas.gerar(new Deck(), nCartas);
		Jogador one = new Jogador("Um",dOne.clone());
		Jogador two = new Jogador("Dois",dTwo.clone());
		one.embaralharDeck();
		two.embaralharDeck();
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(one);
		jogadores.add(two);
		Campo c = new Campo();
		
		Partida p = new Partida(jogadores, c);
		
		p.executaTurno();
		p.executaTurno();
		p.executaTurno();
		*/	
	}
	
	/*
	 * Executar o programa (INICIAR; sem test)
	 */
	public void executePrograma(){
		CardLoader cl = new CardLoader();
		try {
			cl.leitor("cartas.data");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int nCartas = 50;
		Deck dOne = FabricaDeCartas.gerar(cl.dataBase(), nCartas);
		Deck dTwo = FabricaDeCartas.gerar(cl.dataBase(), nCartas);
		System.out.println(dOne.toString());
		System.out.println(dTwo.toString());
		
		Jogador j1 = new Jogador("P1", dOne);
		Jogador j2 = new Jogador("P2", dTwo);

		Campo tabuleiro = new Campo(j1, j2);
		LinkedList<Jogador> fila = new LinkedList<Jogador>();
		fila.add(j1);
		fila.add(j2);
		Partida p = new Partida(fila, tabuleiro);
		p.executaTurno();
		try {
			tabuleiro.porEmCampo(j1.escolheCarta(), j1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
