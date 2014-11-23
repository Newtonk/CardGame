package modelo.Carta;

/*
 * Esta e uma classe que representa o elemento de uma determinada carta.
 */

public enum Elemento {
	
	AGUA, AR, FOGO, TERRA;
	
	public boolean forteContra(Elemento e){
		switch(e){
		case AGUA:
			if(this == TERRA)
				return true;
			break;
		case AR:
			if(this == FOGO)
				return true;
			break;
		case FOGO:
			if(this == AGUA)
				return true;
			break;
		case TERRA:
			if(this == AR)
				return true;
			break;
		default:
				return false;
		}
		return false;
	}

}
