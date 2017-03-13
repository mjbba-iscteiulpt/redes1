package codes;

public class BitParidade {

	private static BitParidade instance = null;

	protected BitParidade() {
		// Exists only to defeat instantiation.
	}

	public static BitParidade getInstance() {
		if (instance == null) {
			instance = new BitParidade();
		}
		return instance;
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
}
