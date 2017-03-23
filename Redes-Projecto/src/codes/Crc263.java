package codes;

import singleton.SuperSingleton;

public class Crc263 {
	
	final int fcs = 8;

	public Crc263() {
		// TODO Auto-generated constructor stub
	}
	
public int[] calcFCS(int[] tramaAux){
		
		int c1, c2, c3, c4, c5, c6, c7, c8, oldC1, oldC2, oldC3, oldC4, oldC5, oldC6, oldC7, oldC8 = 0;
		
		oldC8 = tramaAux[0];
		oldC7 = tramaAux[1];
		oldC6 = tramaAux[2];
		oldC5 = tramaAux[3];
		oldC4 = tramaAux[4];
		oldC3 = tramaAux[5];
		oldC2 = tramaAux[6];
		oldC1 = tramaAux[7];
		
		
			
		for (int i = 8; i< tramaAux.length; i++) {
			c1 = SuperSingleton.getInstance().getAuxCalc().calcXor(oldC8, tramaAux[i]);
			c2 = SuperSingleton.getInstance().getAuxCalc().calcXor(oldC8, oldC1);
			c3 = SuperSingleton.getInstance().getAuxCalc().calcXor(oldC8, oldC2);
			c4 = oldC3;
			c5 = oldC4;
			c6 = oldC5;
			c7 = oldC6;
			c8 = oldC7;
			oldC1 = c1;
			oldC2 = c2;
			oldC3 = c3;
			oldC4 = c4;
			oldC5 = c5;
			oldC6 = c6;
			oldC7 = c7;
			oldC8 = c8;
		}
		
		tramaAux[4] = oldC8;
		tramaAux[5] = oldC7;
		tramaAux[6] = oldC6;
		tramaAux[7] = oldC5;
		tramaAux[8] = oldC4;
		tramaAux[9] = oldC3;
		tramaAux[10] = oldC2;
		tramaAux[11] = oldC1;
		
		
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
