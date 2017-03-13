package codes;

import calcs.AuxCalc;

public class Hamming {

	private static Hamming instance = null;

	protected Hamming() {
		// Exists only to defeat instantiation.
	}

	public static Hamming getInstance() {
		if (instance == null) {
			instance = new Hamming();
		}
		return instance;
	}

	public int[] calcP(int[] trama) {
		int[] vectorOfP = new int[3];
		vectorOfP[0] = AuxCalc.getInstance().calcXor(AuxCalc.getInstance().calcXor(trama[0], trama[1]), trama[3]);
		vectorOfP[1] = AuxCalc.getInstance().calcXor(AuxCalc.getInstance().calcXor(trama[0], trama[2]), trama[3]);
		vectorOfP[2] = AuxCalc.getInstance().calcXor(AuxCalc.getInstance().calcXor(trama[1], trama[2]), trama[3]);
		return vectorOfP;
	}
	
	public int calcC(int[] trama) {
		String stringOfC = "";
		stringOfC+= AuxCalc.getInstance().calcXor(AuxCalc.getInstance().calcXor(AuxCalc.getInstance().calcXor(trama[2], trama[4]), trama[6]), trama[0]);
		stringOfC+= AuxCalc.getInstance().calcXor(AuxCalc.getInstance().calcXor(AuxCalc.getInstance().calcXor(trama[2], trama[5]), trama[6]), trama[1]);
		stringOfC+= AuxCalc.getInstance().calcXor(AuxCalc.getInstance().calcXor(AuxCalc.getInstance().calcXor(trama[4], trama[5]), trama[6]), trama[3]);
		System.out.println(">> C's: "+stringOfC);
		return Integer.parseInt(stringOfC, 2);
	}


}
