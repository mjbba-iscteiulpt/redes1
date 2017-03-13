package receptor;

import codes.BitParidade;
import codes.Hamming;

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
	public void tramaRecebida(int[] trama, int metodoEscolhido) {
		int[] tramaAContar = new int[5];
		
		for (int i=0; i<tramaAContar.length-1; i++){
			tramaAContar[i] = trama[i];
		}
		
		
		switch (metodoEscolhido){
		case 1:
			BitParidade.getInstance().detectErrors(BitParidade.getInstance().countOnes(tramaAContar), trama);
			break;
		case 2:
			System.out.println(Hamming.getInstance().calcC(trama));
			break;
		case 3:
			break;
		case 4:
			break;
		}
		
		
		
		
	}

}
