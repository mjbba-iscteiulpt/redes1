package calcs;

import java.util.Arrays;

public class AuxCalc {
	
	private int[] tramaEnviada;
	private boolean bitCorrigido;

	public AuxCalc() {
		// Exists only to defeat instantiation.
	}

	
	public int calcXor(int value1, int value2) {
		if (value1 != value2)
			return 1;
		return 0;
	}
	
	//Verificar se as tramas enviadas e recebidas são iguais.
	public boolean checkTramas(int[] recebida) {
		if (!Arrays.toString(getTramaEnviada()).equals(Arrays.toString(recebida)))
			return false;
		return true;
	}


	public int[] getTramaEnviada() {
		return tramaEnviada;
	}


	public void setTramaEnviada(int[] tramaEnviada) {
		this.tramaEnviada = tramaEnviada.clone();
	}

	public boolean isBitCorrigido() {
		return bitCorrigido;
	}


	public void setBitCorrigido(boolean bitCorrigido) {
		this.bitCorrigido = bitCorrigido;
	}
	
	
	
	

}
