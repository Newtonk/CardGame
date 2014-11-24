package modelo;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean justTest = false;

		if (!justTest) {
			Sistema.getSistema().executePrograma();
		} else {
			Sistema.getSistema().executeTest();
		}		
	}
}
