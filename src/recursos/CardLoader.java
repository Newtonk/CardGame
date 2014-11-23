package recursos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

import modelo.Carta.Carta;
import modelo.Carta.Elemento;
import modelo.Carta.Monstro;

public class CardLoader {

	LinkedList<Carta> cartas;
	
	public CardLoader(){
		cartas = new LinkedList<>();
	}
	
	public LinkedList<Carta> dataBase(){
		return (LinkedList<Carta>) cartas.clone();
	}
	
	public void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				Carta c = processLine(linha);
				if (c != null){
					cartas.add(c);
				}
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}

	private Carta processLine(String linha) {
		StringTokenizer st = new StringTokenizer(linha, "|");
		if (st.hasMoreTokens()) {
			String tipo = st.nextToken();
			switch (tipo) {
			case "Monstro":
					String nome = st.nextToken();
					String elemento = st.nextToken();
					String mana = st.nextToken();
					String ataque = st.nextToken();
					String vida = st.nextToken();
				try {
					return new Monstro(nome, parseElemento(elemento),parseInt(mana),parseInt(ataque),parseInt(vida)); 
				} catch (IOException e) {
					e.printStackTrace();
				}
			case "Efeito":
				break;
			case "Mana":
				break;
			default:
				System.out.println(tipo);
				System.out.println("Elemento não encontrado.");
			}
		}
		return null;
	}

	private int parseInt(String s) throws IOException {
		int i = 0;
		i = Integer.parseInt(s);
		return i;
	}

	private Elemento parseElemento(String elemento) {
		switch (elemento) {
		case "Agua":
			return Elemento.AGUA;

		case "Ar":
			return Elemento.AR;

		case "Fogo":
			return Elemento.FOGO;

		case "Terra":
			return Elemento.TERRA;
		default:
			System.out.println(elemento);
			System.out.println("Elemento não encontrado.");
		}
		return null;
	}

}
