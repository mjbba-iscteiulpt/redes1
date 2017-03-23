package codes;

import singleton.SuperSingleton;

public class Crc11 {
	
	final int fcs = 3;

	public Crc11() {
		// TODO Auto-generated constructor stub
	}

	
	
	public int[] calcFCS(int[] tramaAux){
		
		int c1, c2, c3, oldC1, oldC2, oldC3 = 0;
		
		oldC3 = tramaAux[0];
		oldC2 = tramaAux[1];
		oldC1 = tramaAux[2];
		
		
			
		for (int i = 3; i< tramaAux.length; i++) {
			c1 = SuperSingleton.getInstance().getAuxCalc().calcXor(oldC3, tramaAux[i]);
			c2 = SuperSingleton.getInstance().getAuxCalc().calcXor(oldC3, oldC1);
			c3 = oldC2;
			oldC1 = c1;
			oldC2 = c2;
			oldC3 = c3;
		}
		
		tramaAux[4] = oldC3;
		tramaAux[5] = oldC2;
		tramaAux[6] = oldC1;
		
		return tramaAux;		
	}
	
	public int checkFCS(int[] trama) {
		String finalFCS = "";
		for (int i = (trama.length-fcs); i<trama.length; i++) {
			finalFCS +=trama[i];
		}
		
		return Integer.parseInt(finalFCS, 2);
	}
}
