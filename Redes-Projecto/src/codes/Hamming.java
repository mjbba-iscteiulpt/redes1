package codes;

import singleton.SuperSingleton;

public class Hamming {

	public Hamming() {
		// Exists only to defeat instantiation.
	}

	public int[] calcP(int[] trama) {
		int[] vectorOfP = new int[3];
		vectorOfP[0] = SuperSingleton.getInstance().getAuxCalc()
				.calcXor(SuperSingleton.getInstance().getAuxCalc().calcXor(trama[0], trama[1]), trama[3]);
		vectorOfP[1] = SuperSingleton.getInstance().getAuxCalc()
				.calcXor(SuperSingleton.getInstance().getAuxCalc().calcXor(trama[0], trama[2]), trama[3]);
		vectorOfP[2] = SuperSingleton.getInstance().getAuxCalc()
				.calcXor(SuperSingleton.getInstance().getAuxCalc().calcXor(trama[1], trama[2]), trama[3]);
		return vectorOfP;
	}

	public int calcC(int[] trama) {
		String stringOfC = "";

		stringOfC += SuperSingleton.getInstance().getAuxCalc().calcXor(SuperSingleton.getInstance().getAuxCalc()
				.calcXor(SuperSingleton.getInstance().getAuxCalc().calcXor(trama[4], trama[5]), trama[6]), trama[3]);
		stringOfC += SuperSingleton.getInstance().getAuxCalc().calcXor(SuperSingleton.getInstance().getAuxCalc()
				.calcXor(SuperSingleton.getInstance().getAuxCalc().calcXor(trama[2], trama[5]), trama[6]), trama[1]);
		stringOfC += SuperSingleton.getInstance().getAuxCalc().calcXor(SuperSingleton.getInstance().getAuxCalc()
				.calcXor(SuperSingleton.getInstance().getAuxCalc().calcXor(trama[2], trama[4]), trama[6]), trama[0]);

		System.out.println(">> C's: " + stringOfC);
		return Integer.parseInt(stringOfC, 2);
	}

}
