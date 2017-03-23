package codes;

import singleton.SuperSingleton;

public class BitParidade {

	public BitParidade() {
		// Exists only to defeat instantiation.
	}


	public int countOnes(int[] trama) {
		int numberOfOnes = 0;
		for (int i = 0; i < trama.length; i++) {
			if (trama[i] == 1)
				numberOfOnes++;
		}
		return numberOfOnes;
	}
	
	
	public int[] calcularParidade(int[] trama) {
		int[] finalTrama = new int[6];
		finalTrama = trama;
		if (countOnes(trama) % 2 == 0)
			finalTrama[finalTrama.length-1] = 0;
		else
			finalTrama[finalTrama.length-1] = 1;

		return finalTrama;
	}
	
	public void detectErrors(int onesTrama, int[] trama) {
		if (onesTrama%2 == 0 && trama[trama.length-1] == 0) {
			System.out.println("Trama sem erro(s) detectados.");
			if (SuperSingleton.getInstance().getAuxCalc().checkTramas(trama)) {
				System.out.println("-- Erros detectados correctamente --");
			} else
				System.out.println("-- Trama com erro(s) não detectados. --");
		} else if (onesTrama%2 !=0 && trama[trama.length-1] == 1) {
			System.out.println("Trama sem erro(s) detectados.");
			if (SuperSingleton.getInstance().getAuxCalc().checkTramas(trama)) {
				System.out.println("-- Erros detectados correctamente --");
			} else
				System.out.println("-- Trama com erro(s) não detectados. --");
		} else {
			System.out.println("Trama com erro(s) detectados.");
			if (SuperSingleton.getInstance().getAuxCalc().checkTramas(trama)) {
				System.out.println("-- Erros detectados correctamente --");
			} else
				System.out.println("-- Trama com erro(s) não detectados. --");
		}
	}
}
