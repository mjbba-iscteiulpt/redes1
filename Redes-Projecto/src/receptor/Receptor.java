package receptor;

import codes.BitParidade;

public class Receptor {

	private static Receptor instance = null;

	protected Receptor() {
		// Exists only to defeat instantiation.
	}

	public static Receptor getInstance() {
		if (instance == null) {
			instance = new Receptor();
		}
		return instance;
	}
	
	//teste
	public void tramaRecebida(int[] trama) {
		int[] tramaAContar = new int[5];
		
		for (int i=0; i<tramaAContar.length-1; i++){
			tramaAContar[i] = trama[i];
		}
		
		int onesTrama = BitParidade.getInstance().countOnes(tramaAContar);
		System.out.println("AQUI"+onesTrama);
		if (onesTrama%2 == 0 && trama[trama.length-1] == 0)
			System.out.println("Trama sem erro(s) detectados.");
		else if (onesTrama%2 !=0 && trama[trama.length-1] == 1)
			System.out.println("Trama sem erro(s) detectados.");
		else
			System.out.println("Trama com erro(s) detectados.");
	}

}
