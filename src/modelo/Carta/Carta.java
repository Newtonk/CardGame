package modelo.Carta;

public class Carta implements Efetivo{

	private int custo;
	private String nome;

	public Carta(String nome, int custo) {
		this.nome = nome;
		this.custo = custo;
	}

	boolean verificaCondEfeito() {
		return false;

	}

	@Override
	public void executaEfeito() {
				
	}
	
	public String toString(){
		return "Nome "+nome+" custo "+custo+"\n";
	}
	
	public Carta clone() {
		return new Carta(this.nome,this.custo);
	}
}
